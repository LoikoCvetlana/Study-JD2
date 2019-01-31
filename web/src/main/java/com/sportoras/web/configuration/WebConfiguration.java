package com.sportoras.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sportoras.web.controller")
@Import(value = {SecurityConfiguration.class, LocationConfiguration.class, ThymeleafConfiguration.class})
public class WebConfiguration {
}
