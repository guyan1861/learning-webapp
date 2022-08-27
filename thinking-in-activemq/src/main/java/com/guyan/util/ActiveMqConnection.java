package com.guyan.util;

import com.guyan.mqconst.ActiveMqConst;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: GuYan
 * @Time: 2022/8/20 02:38
 * @Description: TODO
 **/
public class ActiveMqConnection {

    public static Connection getConnection() throws JMSException {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        MessageConsumer messageConsumer = null;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMqConst.USERNAME, ActiveMqConst.PASSWORD, ActiveMqConst.ACTIVE_MQ_URL);
        connection = connectionFactory.createConnection();
        return connection;
    }

    public static void closeConsumer(MessageConsumer messageConsumer, Session session, Connection connection) {
        if(messageConsumer != null) {
            try {
                messageConsumer.close();
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
        close(session, connection);
    }

    public static void closeProducer(MessageProducer messageProducer, Session session, Connection connection) {
        if(messageProducer != null) {
            try {
                messageProducer.close();
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
        close(session, connection);
    }

    public static void close(Session session, Connection connection) {
        if(session != null) {
            try {
                session.close();
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
