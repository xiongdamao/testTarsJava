package com.qq.tars.quickstart;

import com.qq.tars.spring.annotation.RemotePropertySource;
import com.qq.tars.spring.annotation.EnableTarsServer;
import com.qq.tars.spring.annotation.RemoteConfigSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTarsServer
@RemoteConfigSource({"MemCache.conf"})
public class StartApplication {
    public static void main(String[] args) {
       // System.setProperty("config","C:\\Data\\Work\\银企\\新\\Test\\SpringCloud\\TestTarsJava\\src\\main\\resources\\TestApp.HelloJavaServer.config.conf");
        SpringApplication.run(StartApplication.class, args);
    }
}