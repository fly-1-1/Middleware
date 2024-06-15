package com.jy.direct;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("log_direct","direct");

        String routingKey = "error";
        channel.basicPublish("log_direct",routingKey,null, ("Hello, direct message! :"+routingKey).getBytes());
        MqUtils.closeConnection(channel,connection);
    }
}
