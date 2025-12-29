
package com.giriraj.service;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.dto.PetDTO;
import com.giriraj.exception.OwnerNotFoundException;
import com.giriraj.exception.PetNotFoundException;


public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;
	
	OwnerDTO findOwnerWithPet(int ownerId) throws OwnerNotFoundException;
	
	void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException, PetNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;
	
	void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException;

	void deletePet(int ownerId, int petId) throws OwnerNotFoundException, PetNotFoundException;
}
