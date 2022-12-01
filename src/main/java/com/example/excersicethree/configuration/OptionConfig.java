package com.example.excersicethree.configuration;

import com.example.excersicethree.document.Text;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OptionConfig {

    @Bean
    @Lazy
    public Text getTxt(String id, String text) {
        return new Text(id,text);
    }
}
