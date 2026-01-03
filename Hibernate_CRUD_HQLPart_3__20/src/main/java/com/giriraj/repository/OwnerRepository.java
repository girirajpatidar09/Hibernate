
package com.giriraj.repository;

import java.time.LocalDate;
import java.util.List;

import com.giriraj.entity.Owner;

public interface OwnerRepository {
	List<Owner> findAllOwners();

	List<Owner> findAllOwnersByFirstNameInitials(String firstName);

	List<Owner> findAllOwnersByPetDateOfBirthRange(LocalDate startDate, LocalDate endDate);

	List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize);
}
