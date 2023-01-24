package com.jpk.sfgdi.controllers;

import com.jpk.sfgdi.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController cic;
    @BeforeEach
    void setUp() {
        cic = new ConstructorInjectedController(new ConstructorInjectedGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(cic.getGreeting());
    }
}