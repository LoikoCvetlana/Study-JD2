package com.sportoras.web.configuration;

import com.sportoras.service.configuration.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sportoras.web.controller"})
@Import(value = {LocationConfig.class, ThymeleafConfiguration.class, ServiceConfiguration.class})
public class WebConfiguration {
}
