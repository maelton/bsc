package br.com.maelton.bsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.maelton.bsc")
public class BscApplication {
    public static void main(String[] args) {
        SpringApplication.run(BscApplication.class, args);
    }
}
