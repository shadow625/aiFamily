package com.service;

import com.model.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Producer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    Gson gson =new GsonBuilder().create();
    public void send(String msg){
        Message message =new Message();
        message.setMsg(msg);
        message.setId(System.currentTimeMillis());
        message.setSendTime(new Date());
        kafkaTemplate.send("yo",gson.toJson(message));
    }
}
