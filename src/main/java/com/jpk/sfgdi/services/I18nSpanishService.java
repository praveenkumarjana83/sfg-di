package com.jpk.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("ES")
//@Service("i18nGreetingService")
public class I18nSpanishService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola Mundo - Spanish Greeting";
    }
}
