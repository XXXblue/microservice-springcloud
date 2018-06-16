package com.itmuch.cloud.microservicesimpleprovideruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan("com.itmuch.cloud.microservicesimpleprovideruser.dao")  //扫描的是mapper.xml中namespace指向值的包位置
public class MicroserviceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleProviderUserApplication.class, args);
	}
}
