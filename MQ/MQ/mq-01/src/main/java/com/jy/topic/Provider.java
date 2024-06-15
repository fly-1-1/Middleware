package com.jy.topic;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics", "topic");

        String routingKey = "user.save.del";
        channel.basicPublish("topics", routingKey, null, ("Topics message! "+routingKey).getBytes());

        MqUtils.closeConnection(channel, connection);
    }

}
