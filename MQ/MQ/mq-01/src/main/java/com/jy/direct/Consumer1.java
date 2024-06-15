package com.jy.direct;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("log_direct", "direct");
        //创建一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定队列到交换机 //参数1：队列名，参数2：交换机名，参数3：路由键
        channel.queueBind(queueName, "log_direct", "error");

        //获取消费者消息
        channel.basicConsume( queueName, true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer1 received message: " + new String(body));
            }
        });

    }

}
