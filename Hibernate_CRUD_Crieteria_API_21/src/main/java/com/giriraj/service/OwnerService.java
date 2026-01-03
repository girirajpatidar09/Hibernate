
package com.giriraj.service;

import java.time.LocalDate;
import java.util.List;

import com.giriraj.dto.OwnerDTO;


public interface OwnerService {
	List<OwnerDTO> findAllOwners();

	List<OwnerDTO> findAllOwnersByFirstNameInitials(String firstName);

	List<OwnerDTO> findByAllOwnersByPetDateOfBirthBetween(LocalDate startDate, LocalDate endDate);

	List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize);
}
