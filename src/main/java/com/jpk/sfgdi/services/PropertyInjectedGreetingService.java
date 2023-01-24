package com.jpk.sfgdi.services;

import org.springframework.stereotype.Service;

//commented so we can configure these beans through Java Configuration in config class which is
//annotated with @Configuration
//@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
