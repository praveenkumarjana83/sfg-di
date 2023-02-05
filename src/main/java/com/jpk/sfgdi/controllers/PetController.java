package com.jpk.sfgdi.controllers;

import com.jpk.sfgdi.pets.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(@Qualifier("petService") PetService petService) {
        this.petService = petService;
    }

    public String getPetType() {
        return petService.getPetType();
    }
}
