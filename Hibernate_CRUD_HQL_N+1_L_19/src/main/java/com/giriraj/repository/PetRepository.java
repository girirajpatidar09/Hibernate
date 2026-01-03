
package com.giriraj.repository;

import java.util.List;

import com.giriraj.entity.Pet;


public interface PetRepository {
	Pet findPet(int petId);

	List<Pet> findAllPets();
}
