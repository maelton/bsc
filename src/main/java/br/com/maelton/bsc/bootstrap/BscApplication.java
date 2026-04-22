package br.com.maelton.bsc.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.maelton.bsc")
public class BscApplication {
    public static void main(String[] args) {
        SpringApplication.run(BscApplication.class, args);
    }
}
