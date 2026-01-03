
package com.giriraj.service;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.exception.OwnerNotFoundException;


public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO);

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetailsUsingPersistentState(int ownerId, String petName) throws OwnerNotFoundException;

	void updatePetDetailsUsingDetachedState(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;
}
