
package com.giriraj.service;

import java.util.List;

import com.giriraj.dto.PetDTO;
import com.giriraj.exception.PetNotFoundException;


public interface PetService {
	PetDTO findPet(int petId) throws PetNotFoundException;

	List<PetDTO> findAllPets();
}
