
package com.giriraj.service;

import com.giriraj.dto.PetDTO;
import com.giriraj.exception.PetNotFoundException;

public interface PetService {
	PetDTO findPet(int petId) throws PetNotFoundException;
}
