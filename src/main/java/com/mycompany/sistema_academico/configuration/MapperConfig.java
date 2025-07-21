package com.mycompany.sistema_academico.configuration;

import com.mycompany.sistema_academico.mapper.factory.UserMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapperFactory userMapper() {
        return new UserMapperFactory();
    }
}
