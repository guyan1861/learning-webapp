package com.guyan.queue;

import com.guyan.util.ActiveMqConnection;

import javax.jms.*;

/**
 * @Author: GuYan
 * @Time: 2022/7/17 15:33
 * @Description: TODO
 **/
public class BrokerConsumer {
    public static void main(String[] args) {
        Destination destination;
        MessageConsumer messageConsumer = null;
        Session session = null;
        Connection connection = null;
        try {
            connection = ActiveMqConnection.getConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("HelloWorld");
            messageConsumer = session.createConsumer(destination);
            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null) {
                    String text = textMessage.getText();
                    System.out.println("消费：" + text);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ActiveMqConnection.closeConsumer(messageConsumer, session, connection);
        }
    }
}
