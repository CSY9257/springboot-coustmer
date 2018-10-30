package com.jk.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.jk.controller","com.jk.service","com.jk.app"})
@EnableAutoConfiguration
public class app {

    public static void main(String[] args) {
        System.out.println("1=================");
        SpringApplication.run(app.class,args);

    }
}
