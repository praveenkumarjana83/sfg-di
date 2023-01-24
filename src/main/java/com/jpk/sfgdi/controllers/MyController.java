package com.jpk.sfgdi.controllers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

@Primary
@Controller
public class MyController {

    public String sayHello() {
        return "Hello World - From Primary Bean...";
    }
}
