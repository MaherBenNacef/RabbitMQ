package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rabbitlistenerproject.RabbitMQMessageListener;

@Configuration
public class RabbitMQConfig {

  private static final String MY_QUEUE = "MyQueue";

  /**
   * Creation of new queue with the name MY_QUEUE
   * @return new Queue
   */
  @Bean
  Queue myQueue(){
    return new Queue(MY_QUEUE,true);
  }

  /**
   * Creation a Topic Exchange
   * @return Exchange
   */
  @Bean
  Exchange myExchange(){
    return ExchangeBuilder
        .topicExchange("MyTopicExchange")
        .durable(true)
        .build();
  }

  /**
   * Creating a Binding with Binding Builder
   * @return Binding
   */
  @Bean
  Binding binding(){
    //return new Binding(MY_QUEUE, DestinationType.QUEUE,"MyTopicExchange","topic",null);
    return BindingBuilder
        .bind(myQueue())
        .to(myExchange())
        .with("topic")
        .noargs();
  }


  /**
   * Creation of stable connection between application and RabbitMQ
   * @return cachingConnectionFactory
   */
  @Bean
  ConnectionFactory connectionFactory(){
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
    cachingConnectionFactory.setUsername("guest");
    cachingConnectionFactory.setPassword("guest");
    return cachingConnectionFactory;
  }

  /**
   * Creation of message listener container listenning to messages coming from the  Queue
   * @return simpleMessageListenerContainer
   */
  @Bean
  MessageListenerContainer messageListenerContainer(){
    SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
    simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
    simpleMessageListenerContainer.setQueues(myQueue());
    simpleMessageListenerContainer.setMessageListener((MessageListener) new RabbitMQMessageListener());
    return simpleMessageListenerContainer;
  }



}
