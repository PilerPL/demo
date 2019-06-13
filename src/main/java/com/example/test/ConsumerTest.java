package com.example.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangjibo
 * @date 2019/6/13 11:52
 * @desc
 */
public class ConsumerTest {
    public static void main(String[] args){
        //启动消费者
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
