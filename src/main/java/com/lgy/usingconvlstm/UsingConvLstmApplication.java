package com.lgy.usingconvlstm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lgy.usingconvlstm.Mappers")
@SpringBootApplication
public class UsingConvLstmApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingConvLstmApplication.class, args);
    }

}
