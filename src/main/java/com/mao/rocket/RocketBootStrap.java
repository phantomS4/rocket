package com.mao.rocket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mao.rocket.model")
public class RocketBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(RocketBootStrap.class, args);
  }

}
