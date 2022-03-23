package com.example.spring.rabbitmq.producer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

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
