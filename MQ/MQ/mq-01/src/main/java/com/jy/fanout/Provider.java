package com.jy.fanout;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = MqUtils.getConnection();
        Channel channel = connection.createChannel();

        //将通道声明指定交换机 参数一:交换机名称 参数二:交换机类型
        channel.exchangeDeclare("logs", "fanout");
        //发送消息
        channel.basicPublish("logs", "", null, "Hello Fanout Exchange".getBytes());
        MqUtils.closeConnection(channel,connection);
    }

}
