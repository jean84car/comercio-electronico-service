package com.comercio.electronico.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageProperty {
	
	private Environment env;
	
	public MessageProperty(Environment env) {
		this.env = env;
	}
	
	public String getMessage(String code) {
        return env.getProperty(code);
    }

}
