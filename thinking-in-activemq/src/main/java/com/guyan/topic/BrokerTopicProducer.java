package com.guyan.topic;

import com.guyan.util.ActiveMqConnection;
import org.apache.activemq.command.ActiveMQMessage;

import javax.jms.*;
import java.util.Scanner;

/**
 * @Author: GuYan
 * @Time: 2022/8/20 02:53
 * @Description: TODO
 * 实际使用的话，先把 Java对象转化为 Json，然后再转为 String 字符串发送出去
 * 我看华语是这么做的
 **/
public class BrokerTopicProducer {

    public static void main(String[] args) {
        Connection connection = null;
        Destination destination;
        MessageProducer messageProducer = null;
        Session session = null;
        try {
            connection = ActiveMqConnection.getConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("Hello-World");
            messageProducer = session.createProducer(destination);
            messageProducer.setDisableMessageID(true);
            Scanner scanner = new Scanner(System.in);
            String response;
            //for (int i = 0; i < 100; i++) {
            //    TextMessage textMessage = session.createTextMessage("【生产者消息：Hello World" + i);
            //    ActiveMQMessage activeMQMessage = (ActiveMQMessage) textMessage;
            //    activeMQMessage.setJMSMessageID("我要改动 Message ID" + i);
            //    messageProducer.send(activeMQMessage);
            //}
            System.out.println("输入消息：");
            while (!(response = scanner.nextLine()).equalsIgnoreCase("Quit")) {
                TextMessage textMessage = session.createTextMessage("生产者发送消息：" + response);
                ActiveMQMessage activeMQMessage = (ActiveMQMessage) textMessage;
                messageProducer.send(activeMQMessage);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            ActiveMqConnection.closeProducer(messageProducer, session, connection);
        }
    }
}
