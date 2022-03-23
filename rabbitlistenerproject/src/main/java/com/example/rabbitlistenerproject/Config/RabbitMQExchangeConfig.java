package com.example.rabbitlistenerproject.Config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

  /**
   * Creation of new Exchange
   * @return Exchange
   */
  @Bean
  Exchange exampleExchange(){
    return new TopicExchange("ExampleExchange");
  }
  /**
   * Creation of new Direct Exchange with another way
   * @return new Exchange
   */
  @Bean
  Exchange example2ndExchange(){
    return ExchangeBuilder
        .directExchange("Example2ndExchange")
        .autoDelete()
        .internal()
        .build();
  }
  /**
   * Creation of new Topic Exchange
   * @return new Exchange
   */
  @Bean
  Exchange newExchange(){
    return ExchangeBuilder
        .topicExchange("TopicTestExchange")
        .autoDelete()
        .internal()
        .durable(true)
        .build();
  }
  /**
   * Creation of new Fanout Exchange
   * @return new Exchange
   */
  @Bean
  Exchange fanoutExchange(){
    return ExchangeBuilder
        .fanoutExchange("fanoutExchange")
        .autoDelete()
        .durable(false)
        .internal()
        .build();
  }

  /**
   * Creation of new Headers Exchange
   * @return new Exchange
   */
  @Bean
  Exchange headerExchange(){
    return ExchangeBuilder
        .headersExchange("headerExchange")
        .autoDelete()
        .durable(false)
        .internal()
        .ignoreDeclarationExceptions()
        .build();
  }
}
