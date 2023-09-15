package com.reworked;

import javax.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { PostMicroService.class, Jsr310Converters.class })

public class PostMicroService {

    public static void main(String[] args) {
        SpringApplication.run(PostMicroService.class, args);
    }

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
