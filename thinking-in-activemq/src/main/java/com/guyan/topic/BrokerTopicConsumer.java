package com.guyan.topic;

import com.guyan.util.ActiveMqConnection;

import javax.jms.*;

/**
 * @Author: GuYan
 * @Time: 2022/8/20 02:52
 * @Description: TODO
 **/
public class BrokerTopicConsumer {
    public static void main(String[] args) throws JMSException {
        Connection connection = null;
        Destination destination;
        MessageConsumer messageConsumer = null;
        Session session = null;
        try {
            connection = ActiveMqConnection.getConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("Hello-World");
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(message instanceof TextMessage) {
                        TextMessage text = (TextMessage) message;
                        try {
                            System.out.println("消费者消费消息" + text.getText());
                        } catch (JMSException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
