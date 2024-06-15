package com.jy.topic;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", "topic");

        String queueName = channel.queueDeclare().getQueue();

        //绑定
        channel.queueBind(queueName, "topics", "user.*");

        //接收消息
        channel.basicConsume(queueName, true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer1 received message: " + new String(body));
            }
        });
    }

}
