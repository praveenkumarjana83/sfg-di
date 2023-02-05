package com.jpk.sfgdi.pets;

public class PetServiceFactory {

    public PetService getPetService(String petType) {
        if (petType.equals("cat")) {
            return new CatPetService();
        }
        return new DogPetService();
    }
}
