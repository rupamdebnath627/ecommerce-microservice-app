package com.products.configuraion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfiguration {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
