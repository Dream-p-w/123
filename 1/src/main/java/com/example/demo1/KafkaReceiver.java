package com.example.demo1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaReceiver {

   /* @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate template;*/

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @KafkaListener(topics = {"zhisheng1"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

           String message = (String) kafkaMessage.get();

           /*拿到消息以后，存入redis*/
          /*  template.opsForValue().set("3",message);*/
            stringRedisTemplate.opsForValue().set("5",message);

            System.out.print(message);
        }

    }
}
