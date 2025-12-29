
package com.giriraj.repository;

import com.giriraj.entity.Owner;


public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(int ownerId);
	
	Owner findOwnerWithPet(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);
}
