package com.guyan.queue;

import com.guyan.util.ActiveMqConnection;

import javax.jms.*;

/**
 * @Author: GuYan
 * @Time: 2022/7/17 15:32
 * @Description: TODO
 **/
public class BrokerProducer {

    public static void main(String[] args) {

        Connection connection = null;
        Destination destination;
        MessageProducer messageProducer = null;
        Session session = null;

        try {
            connection = ActiveMqConnection.getConnection();

            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("HelloWorld");

            messageProducer = session.createProducer(destination);

            sendMessage(session, messageProducer);

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            ActiveMqConnection.closeProducer(messageProducer, session, connection);
        }
    }

    /**
     * 生产者发送消息
     */
    public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送消息" + i);
            System.out.println("ActiveMq 发送消息" + i);
            messageProducer.send(message);
        }
    }
}
