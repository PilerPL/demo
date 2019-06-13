package com.example.listener;

import javax.jms.*;
/**
 * @author yangjibo
 * @date 2019/6/13 11:54
 * @desc
 */
public class ComsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("Spring消费者获取消息：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
