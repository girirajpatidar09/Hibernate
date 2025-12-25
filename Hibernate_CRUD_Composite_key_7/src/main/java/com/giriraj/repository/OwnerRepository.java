package com.giriraj.repository;

import com.giriraj.entity.Owner;
import com.giriraj.entity.OwnerPetPrimaryKey;

public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(OwnerPetPrimaryKey primaryKey);

	void updatePetDetails( OwnerPetPrimaryKey primaryKey, String petName);

	void deleteOwner(OwnerPetPrimaryKey primaryKey);
}