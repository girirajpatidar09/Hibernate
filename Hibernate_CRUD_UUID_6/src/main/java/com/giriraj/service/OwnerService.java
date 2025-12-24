
package com.giriraj.service;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.exception.OwnerNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO)  ;

	OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException;

	void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException;


	void deleteOwner(String ownerId) throws OwnerNotFoundException;

}
