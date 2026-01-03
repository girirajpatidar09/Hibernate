
package com.giriraj.service;

import java.util.List;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.exception.OwnerNotFoundException;


public interface OwnerService {
	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	OwnerDTO findOwnerWithPet(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();

	List<OwnerDTO> findAllOwnersWithPet();
}
