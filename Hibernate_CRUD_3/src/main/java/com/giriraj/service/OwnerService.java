
package com.giriraj.service;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.exception.DuplicateOwnerException;
import com.giriraj.exception.OwnerNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException ;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;


	void deleteOwner(int ownerId) throws OwnerNotFoundException;

}
