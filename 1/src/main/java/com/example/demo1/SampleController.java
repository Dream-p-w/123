package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SampleController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @RequestMapping("/customer")
    public String first(){

         long time=new  Date().getTime();
         System.out.print(time);
         String time1=Long.toString(time);
        kafkaTemplate.send("zhisheng1", time1);
         String message=stringRedisTemplate.opsForValue().get("5");


        return message;
    }



}