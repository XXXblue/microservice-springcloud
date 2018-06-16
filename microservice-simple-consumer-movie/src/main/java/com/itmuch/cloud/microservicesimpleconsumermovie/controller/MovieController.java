package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/1310:19
 * @Description:
 * @Modified By:
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id){
        //如果这个地方没有指定协议 http还是什么就会失败
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        System.out.println(serviceInstance.getHost()+"------"+serviceInstance.getPort()+"---------------"+serviceInstance.getServiceId());
//        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
//        System.out.println(serviceInstance2.getHost()+"------"+serviceInstance2.getPort()+"----------------"+serviceInstance2.getServiceId());
        return "1";
    }
}
