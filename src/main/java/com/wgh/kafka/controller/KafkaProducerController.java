package com.wgh.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.wgh.kafka.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WGH
 * @Date 2022-08-03 23:03
 * @Description
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.consumer.group-id}")
    private String topic;

    @RequestMapping("/hello")
    public String hello() {
        Student student = new Student();
        student.setName("wgh");
        student.setAge(99);
        kafkaTemplate.send(topic, JSON.toJSONString(student));
        return "ok";
    }
}
