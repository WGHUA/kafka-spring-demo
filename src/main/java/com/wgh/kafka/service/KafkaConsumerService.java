package com.wgh.kafka.service;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author WGH
 * @Date 2022-08-03 23:47
 * @Description
 */
@Component
public class KafkaConsumerService {

    @Value("${spring.kafka.consumer.group-id}")
    private String topic;

    @KafkaListener(topics = {"kafka-spring-demo-group"})
    public void receiverMessage(ConsumerRecord<?, ?> record) {
        Optional<? extends ConsumerRecord<?, ?>> optional = Optional.ofNullable(record);
        if (optional.isPresent()) {
            Object value = record.value();
            System.out.println(JSON.parseObject(String.valueOf(value)));
        }
    }

}
