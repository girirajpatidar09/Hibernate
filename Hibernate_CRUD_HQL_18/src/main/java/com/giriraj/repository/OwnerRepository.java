
package com.giriraj.repository;

import java.util.List;

import com.giriraj.entity.Owner;


public interface OwnerRepository {
	Owner findOwner(int ownerId);

	List<Owner> findAllOwners();
}
