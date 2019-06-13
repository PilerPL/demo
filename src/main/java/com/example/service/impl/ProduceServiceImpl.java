package com.example.service.impl;

import com.example.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author yangjibo
 * @date 2019/6/13 11:39
 * @desc 生产者实现类
 */
public class ProduceServiceImpl implements ProduceService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    private Destination destination;
    @Override
    public void sendMessage(String msg) {
        jmsTemplate.send(destination , new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.println("现在发送的消息为： " + msg);
    }

    }
