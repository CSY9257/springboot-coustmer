package com.jk.utils;

import com.jk.service.GoodsService;
import org.springframework.amqp.core.AmqpTemplate;

/*千万不要再线程类里面注入任何东西，如果你注入了，或者写了@autowrite,那么你就是个傻子*/
public class TestThread implements Runnable{

    private AmqpTemplate amqpTemplate;
    private GoodsService goodsService;
    private String uuid;

    public TestThread(GoodsService goodsService, String uuid) {
         this.goodsService = goodsService;
         this.uuid = uuid;
    }
    public TestThread(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }



    @Override
    public void run() {
       send();
    }

    public TestThread() {
    }

    public void send(){
        goodsService.sendUuid(uuid);
    }
}
