
package com.giriraj.service.impl;

import java.util.Objects;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.dto.PetDTO;
import com.giriraj.entity.Owner;
import com.giriraj.entity.Pet;
import com.giriraj.exception.OwnerNotFoundException;
import com.giriraj.exception.OwnerPetCombinationNotFoundException;
import com.giriraj.exception.PetNotFoundException;
import com.giriraj.repository.OwnerRepository;
import com.giriraj.repository.PetRepository;
import com.giriraj.repository.impl.OwnerRepositoryImpl;
import com.giriraj.repository.impl.PetRepositoryImpl;
import com.giriraj.service.OwnerService;
import com.giriraj.util.MapperUtil;


public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	
	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
		this.petRepository = new PetRepositoryImpl();
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :" +ownerId);
		}
		return MapperUtil.convertOwnerEntityToDtoWithoutPet(owner);
	}
	
	@Override
	public OwnerDTO findOwnerWithPet(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ownerId);
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}
	
	@Override
	public void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException, OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ ownerId);
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new OwnerPetCombinationNotFoundException("OWNER_PET_COMBINATION_NOT_FOUND :"+petId+","+ ownerId);
		} else {
			ownerRepository.updatePetDetails(ownerId, petId, petName);
		}
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ ownerId);
		}
		ownerRepository.deleteOwner(ownerId);
	}
	
	@Override
	public void addPet(int ownerId, PetDTO petDTO) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ownerId);
		}
		Pet pet = MapperUtil.convertPetDtoToEntity(petDTO);
		ownerRepository.addPet(ownerId, pet);
	}

	@Override
	public void removePet(int ownerId, int petId) throws OwnerNotFoundException, OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ownerId);
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new OwnerPetCombinationNotFoundException("OWNER_PET_COMBINATION_NOT_FOUND :"+ petId+"," +ownerId);
		} else {
			ownerRepository.removePet(ownerId, petId);
		}
	}
	
	@Override
	public void addCoOwner(int petId, OwnerDTO ownerDTO) throws PetNotFoundException {
		Pet pet = petRepository.findPet(petId);
		if (Objects.isNull(pet)) {
			throw new PetNotFoundException("PET_NOT_FOUND :" +petId);
		} else {
			Owner owner = MapperUtil.convertOwnerDtoToEntityWithoutPet(ownerDTO);
			ownerRepository.addCoOwner(petId, owner);
		}
	}
}
