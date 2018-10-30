package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.User;
import com.jk.service.GoodsService;
import com.jk.utils.TestThread;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @Autowired
    private AmqpTemplate amqpTemplate;


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/test")
    public void toCall() {
        goodsService.getUserInfo();
    }






    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    @RequestMapping("send")
    public String send(){
        User user = new User();
        user.setId(11);
        amqpTemplate.convertAndSend("1804aa", JSON.toJSONString(user));
        return "aaaa";
    }

    @RequestMapping("threadSend")
    public String threadSend(){
        String uuid = UUID.randomUUID().toString();
        singleThreadExecutor.execute(new TestThread(goodsService,uuid));
        return "bbb";
    }


    @RequestMapping("toRedis")
    public void toRedis(){

        redisTemplate.opsForValue().set("楚楚","123");
    }

    @RequestMapping("toMongo")
    public void toMongo(){
        User user = new User();
        user.setId(4);
        user.setPassword("123");
        user.setUsername("吴钰祯");
        mongoTemplate.insert(user);
    }

}


