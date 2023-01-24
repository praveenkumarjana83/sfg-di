package com.jpk.sfgdi.config;

import com.jpk.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishService i18Service() {
        return new I18nEnglishService();
    }

    @Profile("ES")
    @Bean("i18Service")
    I18nSpanishService i18nSpanishService() {
        return new I18nSpanishService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    //Bean methods should be overridable, i.e., default, protected & public, can't be declared as private or final
    ConstructorInjectedGreetingService constructorInjectedGreetingService() {
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
