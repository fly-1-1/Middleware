package com.jy.work;

import com.jy.work.utils.MqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();
        //每次只接收一条消息
        channel.basicQos(1);
        channel.queueDeclare("work", false, false, false, null);
        //参数二:是否自动确认消息,true:自动确认消息,false:需要手动确认消息
        channel.basicConsume("work", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者" + consumerTag + "接收到消息：" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }
}
