package com.lhf.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 当client向server注册时，它会提供一些元数据，
 * 例如主机和端口，URL，主页等。Eureka server 从每个client实例接收心跳消息。
 * 如果心跳超时，则通常将该实例从注册server中删除。
 */

@SpringBootApplication
@EnableEurekaClient   //表明自己是一个注册服务客户端
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String name;

    //TODO http://localhost:8082/index
    @RequestMapping("/index")
    public String index(){
        return "服务名：" + name + ", port:" + port;
    }

    //TODO http://localhost:8082/hello?message=liuhefei
    //TODO http://localhost:8082/hello
    @RequestMapping("/hello")
    public String home(@RequestParam(value="message", defaultValue = "hello world" ) String message){
        return "<h1>message:</h1>" + message;
    }


}

