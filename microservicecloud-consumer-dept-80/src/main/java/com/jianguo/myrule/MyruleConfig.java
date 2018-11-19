package com.jianguo.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyruleConfig {
    @Bean
    public IRule getIRule() {
        System.out.println("-----true = " + true);
        return new MyRandomBinRule();
    }

}
