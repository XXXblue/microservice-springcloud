package com.itmuch.cloud.microservicesimpleconsumermovie;

import com.itmuch.config.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//这个name可不是随便写的，这个名字是针对谁进行负载均衡，而TestConfiguration是你自定义配置Ribbon
//@RibbonClient(name = "microservice-provider-user",configuration = TestConfiguration.class)
public class MicroserviceSimpleConsumerMovieApplication {
	// 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
	@Autowired
	private RestTemplateBuilder builder;
	// 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
	// 使用Ribbon的第二步便是到movie的启动类中添加一个注解@LoadBalanced，这一个注解作用可不小，它就可以帮我们做负载均衡的复杂工作。
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return builder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieApplication.class, args);
	}
}
