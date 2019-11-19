package com.bjsxt.item;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.bjsxt.mapper")
@EnableDistributedTransaction
public class CommonItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonItemApplication.class,args);
    }
}
