package br.com.meuprojeto;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class HotelPetTest {

    @Test
    void deveCadastrarPet() {
        HotelPet hotel = new HotelPet();
        Pet pet = new Pet("Rex", "Cachorro", "Labrador", 5);
        hotel.cadastrarPet(pet);
        assertTrue(hotel.getPets().contains(pet));
    }
}
