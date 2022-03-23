package com.example.spring.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

  @RabbitListener(queues = MQConfig.MESSAGE_QUEUE)
  public void listener(CustomMessage message){
    System.out.println(message.getMessaqeId());
    System.out.println(message.getMessageDate());
    System.out.println(message.getMessage());
    if (Integer.valueOf(message.getMessage())>3)
    {
      for (char c:message.getMessage().toCharArray()) {
        for (int i=0;i<10000;i++){
            System.out.println(i);
        }
      }
    }
  }
}
