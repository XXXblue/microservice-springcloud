package com.itmuch.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/1514:17
 * @Description:
 * @Modified By:
 */
@Configuration
public class TestConfiguration {
    @Autowired
    IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }
}
