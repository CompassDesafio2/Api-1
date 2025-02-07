package com.rafaelmachado.microservicea;

import com.rafaelmachado.microservicea.feing.PostagemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MicroserviceAApplication  {
    public static void main(String[] args) 
    {
        SpringApplication.run(MicroserviceAApplication.class, args);
    }

}