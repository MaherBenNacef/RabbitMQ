package com.example.rabbitlistenerproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQMessageListener implements MessageListener {

  @Autowired
  private ModelMapper mapper;

  @Override
  public void onMessage(Message message)  {
   /* ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(message.getBody());
    try {
      ObjectInput input = new ObjectInputStream(byteArrayInputStream);
      SimpleMesssage msg = (SimpleMesssage) input.readObject();
      System.out.println(msg.getName());
      System.out.println(msg.getDescription());
    } catch (IOException e) {
      e.printStackTrace();
    }catch (ClassNotFoundException e){
      e.printStackTrace();
    }*/
    /*try {

      SimpleMesssage simpleMesssage = mapper.map(message,SimpleMesssage.class);
      System.out.println(simpleMesssage);
    }catch (NullPointerException e){
      System.out.println("la valeur est null");
    }*/
   System.out.println("message = " + message);
  }


}
