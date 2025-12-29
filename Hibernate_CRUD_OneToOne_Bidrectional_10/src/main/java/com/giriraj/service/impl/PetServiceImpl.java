
package com.giriraj.service.impl;

import java.util.Objects;

import com.giriraj.dto.PetDTO;
import com.giriraj.entity.Pet;
import com.giriraj.exception.PetNotFoundException;
import com.giriraj.repository.PetRepository;
import com.giriraj.repository.impl.PetRepositoryImpl;
import com.giriraj.service.PetService;
import com.giriraj.util.MapperUtil;


public class PetServiceImpl implements PetService {
	private PetRepository petRepository;
	
	public PetServiceImpl() {
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		Pet pet = petRepository.findPet(petId);
		if (Objects.isNull(pet)) {
			throw new PetNotFoundException("PET_NOT_FOUND "+ petId);
		}
		return MapperUtil.convertPetEntityToDto(pet);
	}
}
