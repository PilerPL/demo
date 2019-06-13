package com.example.test;

import com.example.service.ProduceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangjibo
 * @date 2019/6/13 11:45
 * @desc 生产者测试类
 */
public class ProduceTest {
    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("producer.xml");
        ProduceService bean = classPathXmlApplicationContext.getBean(ProduceService.class);
        //进行发送消息
        for (int i = 0; i < 100 ; i++) {
            bean.sendMessage("test" + i);
        }
        //当消息发送完后，关闭容器
        classPathXmlApplicationContext.close();
    }

}
