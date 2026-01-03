
package com.giriraj.service.impl;

import com.giriraj.repository.PetRepository;
import com.giriraj.repository.impl.PetRepositoryImpl;
import com.giriraj.service.PetService;


public class PetServiceImpl implements PetService {
	private PetRepository petRepository;

	public PetServiceImpl() {
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public Double findAverageAgeOfPet() {
		return petRepository.findAverageAgeOfPet();
	}
}
