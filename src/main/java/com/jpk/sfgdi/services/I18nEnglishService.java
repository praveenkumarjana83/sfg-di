package com.jpk.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"EN", "default"})
//@Service("i18nGreetingService")
public class I18nEnglishService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - EN Service - Profile example";
    }
}
