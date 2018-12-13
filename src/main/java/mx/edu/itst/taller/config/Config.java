/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itst.taller.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author yuls
 */
@Configuration
public class Config {
    
    @Bean
    public ObjectMapper createObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper;
    }
}
