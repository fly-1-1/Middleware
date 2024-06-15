package com.jy.direct;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("log_direct", "direct");
        //声明临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定队列到交换机
        channel.queueBind(queueName, "log_direct", "info");
        channel.queueBind(queueName, "log_direct", "error");
        channel.queueBind(queueName, "log_direct", "warning");
        //消费消息
        channel.basicConsume(queueName, true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer2 received: " + new String(body));
            }
        });
    }

}
