package com.jy.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    //生产消息
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        //创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接mq主机
        connectionFactory.setHost("192.168.157.140");
        //设置连接mq端口
        connectionFactory.setPort(5672);
        //设置连接那个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("root");

        //获取连接对象
        Connection connection = connectionFactory.newConnection();
        //获取连接中的通道对象
        Channel channel = connection.createChannel();
        //绑定对应的消息队列
        //参数一：队列名称 参数二：是否持久化  参数三：是否独占  参数四：是否自动删除  参数五：额外参数
        channel.queueDeclare("hello",false,false,false,null);

        //发布消息
        //参数一：交换机名称  参数二：队列名称  参数三：传递消息的额外设置  参数四：消息内容
        channel.basicPublish("","hello",null,"hello mq".getBytes());

        channel.close();
        connection.close();

    }

}
