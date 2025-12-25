
package com.giriraj.service;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.entity.OwnerPetPrimaryKey;
import com.giriraj.exception.DuplicateOwnerException;
import com.giriraj.exception.OwnerPetCombinationNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException ;

	OwnerDTO findOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException;
	void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName) throws OwnerPetCombinationNotFoundException;


	void deleteOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException;

}
