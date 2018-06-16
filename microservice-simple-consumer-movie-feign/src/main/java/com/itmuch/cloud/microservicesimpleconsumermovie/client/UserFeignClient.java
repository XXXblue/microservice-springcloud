package com.itmuch.cloud.microservicesimpleconsumermovie.client;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/1610:10
 * @Description:
 * @Modified By:
 */

import com.itmuch.cloud.microservicesimpleconsumermovie.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
