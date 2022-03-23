package com.example.spring.rabbitmq.consumer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomMessage {

  private String messaqeId;
  private String message;
  private Date messageDate;
}
