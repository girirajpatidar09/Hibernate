
package com.giriraj.repository;

import com.giriraj.entity.Pet;


public interface PetRepository {
	Pet findPet(int petId);
}
