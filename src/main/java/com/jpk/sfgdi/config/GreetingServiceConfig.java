package com.jpk.sfgdi.config;

import com.jpk.sfgdi.datasource.FakeDataSource;
import com.jpk.sfgdi.pets.PetService;
import com.jpk.sfgdi.pets.PetServiceFactory;
import com.jpk.sfgdi.repositories.EnglishGreetingRepository;
import com.jpk.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.jpk.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SFGConstructorConfig.class)
//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Profile({"dog", "default"})
    @Bean("petService")
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean("petService")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile({"EN", "default"})
    @Bean
    I18nEnglishService i18Service() {
        return new I18nEnglishService(englishGreetingRepository());
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

    //@Bean
    //commented out the Bean annotation to try out this configuration from
    //spring configuration xml file (sfgdi-config.xml)
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

    @Bean
    FakeDataSource fakeDataSource(
            @Value("${jpk.username}") String username,
            @Value("${jpk.password}") String password,
            @Value("${jpk.jdbcurl}") String jdbcURL
    ) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcURL(jdbcURL);
        return fakeDataSource;
    }
}
