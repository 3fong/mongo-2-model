package com.liu;

import com.liu.service.MongoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        MongoService bean = applicationContext.getBean("mongoService",MongoService.class);
        bean.write();
    }
}
