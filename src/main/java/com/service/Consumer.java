package com.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Consumer {
    private static final String TAG = "shadow-log";
    @KafkaListener(topics = {"yo"})
    public void listen(ConsumerRecord<?,?> consumerRecord){
        Optional<?> Kmessage = Optional.ofNullable(consumerRecord);
        if (Kmessage.isPresent()) {
            // 检查消息是否读取成功，message对象是否存在。
            Object message = Kmessage.get();
            System.out.println(message.toString());
        }
    }
}
