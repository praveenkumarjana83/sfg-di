package com.jpk.sfgdi.controllers;

import com.jpk.sfgdi.services.SetterInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController sic;
    @BeforeEach
    void setUp() {
        sic = new SetterInjectedController();
        sic.setGreetingService(new SetterInjectedGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(sic.getGreeting());
    }
}