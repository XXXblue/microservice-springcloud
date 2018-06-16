package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/1510:12
 * @Description:
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String args[]){
        SpringApplication.run( EurekaApplication.class, args);
    }
}
