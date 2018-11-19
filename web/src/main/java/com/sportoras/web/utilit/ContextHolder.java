package com.sportoras.web.utilit;

import com.sportoras.service.configuration.ServiceConfiguration;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@UtilityClass
public class ContextHolder {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);

    public AnnotationConfigApplicationContext getContext() {
        return context;
    }
}