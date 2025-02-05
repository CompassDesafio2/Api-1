package com.rafaelmachado.microservicea;

import com.rafaelmachado.microservicea.feing.PostagemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceAApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAApplication.class, args);
    }

    @Autowired
    private PostagemClient postagemClient;


    @Override
    public void run(String... args) throws Exception {
        this.postagemClient.buscarTudo();
        System.out.println(this.postagemClient.buscarTudo());

    }
}
