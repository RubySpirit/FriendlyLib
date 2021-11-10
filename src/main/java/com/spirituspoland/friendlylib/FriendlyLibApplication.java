package com.spirituspoland.friendlylib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@EnableScheduling
@SpringBootApplication
public class FriendlyLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendlyLibApplication.class, args);
    }

}
