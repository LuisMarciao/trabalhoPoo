package br.com.meuprojeto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void deveCriarPetCorretamente() {
        Pet pet = new Pet("Rex", "Cachorro", "Labrador", 5);
        assertEquals("Rex", pet.getNome());
        assertEquals("Cachorro", pet.getEspecie());
        assertEquals("Labrador", pet.getRaca());
        assertEquals(5, pet.getIdade());
    }
}
