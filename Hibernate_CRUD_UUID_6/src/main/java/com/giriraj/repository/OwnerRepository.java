package com.giriraj.repository;

import java.util.UUID;

import com.giriraj.entity.Owner;

public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(UUID ownerId);

	void updatePetDetails(UUID ownerId, String petName);

	void deleteOwner(UUID ownerId);
}