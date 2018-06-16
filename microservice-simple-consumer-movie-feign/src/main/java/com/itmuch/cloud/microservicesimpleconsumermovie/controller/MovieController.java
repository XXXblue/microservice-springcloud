package com.itmuch.cloud.microservicesimpleconsumermovie.controller;

import com.itmuch.cloud.microservicesimpleconsumermovie.client.UserFeignClient;
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
    private UserFeignClient userFeignClient;
    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

}
