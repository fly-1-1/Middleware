package com.jy.helloworld;

import com.jy.helloworld.utils.MqUtils;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {


    public static void main(String[] args) throws IOException, TimeoutException {
//        //创建连接mq的连接工厂对象
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        //设置连接mq主机
//        connectionFactory.setHost("192.168.157.140");
//        //设置连接mq端口
//        connectionFactory.setPort(5672);
//        //设置连接那个虚拟主机
//        connectionFactory.setVirtualHost("/ems");
//        //设置用户名和密码
//        connectionFactory.setUsername("ems");
//        connectionFactory.setPassword("root");
//
//
//        //获取连接对象
//        Connection connection = connectionFactory.newConnection();
        Connection connection = MqUtils.getConnection();

        //获取连接中的通道对象
        Channel channel = connection.createChannel();
        //绑定对应的消息队列
        //参数一：队列名称 参数二：是否持久化  参数三：是否独占  参数四：是否自动删除  参数五：额外参数
        channel.queueDeclare("hello", false, false, false, null);


        //消费消息
        //参数一：队列名称 参数二：是否自动确认  参数三：回调对象
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {

            //参数一：消息对象,参数二：消息的属性,参数三：消息体
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new message received: " + new String(body));
            }
        });

        //关闭连接
        //MqUtils.closeConnection(channel, connection);
    }


   /* @Test
    public void testConsumer() throws IOException, TimeoutException {


    }*/
}
