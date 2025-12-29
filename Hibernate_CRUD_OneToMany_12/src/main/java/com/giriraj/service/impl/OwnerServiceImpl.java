
package com.giriraj.service.impl;

import java.util.Objects;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.dto.PetDTO;
import com.giriraj.entity.Owner;
import com.giriraj.entity.Pet;
import com.giriraj.exception.OwnerNotFoundException;
import com.giriraj.exception.PetNotFoundException;
import com.giriraj.repository.OwnerRepository;
import com.giriraj.repository.impl.OwnerRepositoryImpl;
import com.giriraj.service.OwnerService;
import com.giriraj.util.MapperUtil;


public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	
	

	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
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
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :"+ownerId);
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
	public void updatePetDetails(int ownerId, int petId, String petName) throws OwnerNotFoundException, PetNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(" OWNER_NOT_FOUND :"+ownerId);
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new PetNotFoundException("PET_NOT_FOUND :" +ownerId);
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
			throw new OwnerNotFoundException("OWNER_NOT_FOUND:" +ownerId);
		}
		Pet pet = MapperUtil.convertPetDtoToEntity(petDTO);
		pet.setOwner(owner);
		ownerRepository.addPet(ownerId, pet);
	}

	@Override
	public void deletePet(int ownerId, int petId) throws OwnerNotFoundException, PetNotFoundException {
		Owner owner = ownerRepository.findOwnerWithPet(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("OWNER_NOT_FOUND :" +ownerId);
		} else if (owner.getPetList().stream().filter(pet -> pet.getId() == petId).findFirst().isEmpty()) {
			throw new PetNotFoundException("PET_NOT_FOUND :" +ownerId);
		} else {
			ownerRepository.deletePet(ownerId, petId);
		}
	}
}
