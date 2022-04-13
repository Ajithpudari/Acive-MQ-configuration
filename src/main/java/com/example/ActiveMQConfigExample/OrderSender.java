package com.example.ActiveMQConfigExample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;



import static com.example.ActiveMQConfigExample.ActiveMQConfig.ORDER_QUEUE;

@Service
public class OrderSender {

    private static Logger log =  LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendQueue(Order order) {
        log.info("sending with convertAndSend() to queue <" + order + ">");
        jmsTemplate.convertAndSend(ORDER_QUEUE, order);
    }

}