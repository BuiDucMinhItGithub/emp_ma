package com.emp_ma;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpMaApplication {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmpMaApplication.class, args);
    }


}
