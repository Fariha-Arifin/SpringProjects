package com.love2code.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages="com.love2code.springsecurity.demo")
@Configuration
@EnableWebMvc
public class DemoAppConfig {

	@Bean
	public ViewResolver viewresover()
	{
		InternalResourceViewResolver v = new InternalResourceViewResolver();
		
		v.setPrefix("/WEB-INF/view/");
		v.setSuffix(".jsp");
		
		return v;
	}
}
