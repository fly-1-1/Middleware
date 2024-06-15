package com.jy.work;

import com.jy.work.utils.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("work", false, false, false, null);

        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "work", null, (i + "work queue").getBytes());
        }
        MqUtils.closeConnection(channel, connection);
    }

}
