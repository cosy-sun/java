package com.cosy.sun.txlcntm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class DemoTmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTmApplication.class, args);
    }

}
