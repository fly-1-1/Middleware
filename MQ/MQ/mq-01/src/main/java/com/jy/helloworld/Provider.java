package com.jy.helloworld;

import com.jy.utils.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    //生产消息
    @Test
    public void testSendMessage() throws IOException, TimeoutException {

        Connection connection = MqUtils.getConnection();
        //获取连接中的通道对象
        Channel channel = connection.createChannel();
        //绑定对应的消息队列
        //参数一：队列名称 参数二：是否持久化  参数三：是否独占  参数四：是否自动删除  参数五：额外参数
        channel.queueDeclare("hello",false,false,false,null);

        //发布消息
        //参数一：交换机名称  参数二：队列名称  参数三：传递消息的额外设置   参数四：消息内容
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello mq".getBytes());

        MqUtils.closeConnection(channel, connection);

    }

}
