package com.giriraj.service.impl;

import java.util.Objects;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.entity.Owner;
import com.giriraj.entity.OwnerPetPrimaryKey;
import com.giriraj.exception.DuplicateOwnerException;
import com.giriraj.exception.OwnerPetCombinationNotFoundException;
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
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {
		
		OwnerPetPrimaryKey primaryKey = new OwnerPetPrimaryKey();
		primaryKey.setId(ownerDTO.getId());
		primaryKey.setPetId(ownerDTO.getPetId());
		
		Owner existingOwner = ownerRepository.findOwner(primaryKey);

		if (Objects.nonNull(existingOwner)) {
			throw new DuplicateOwnerException("Owner already exits  with id:" + ownerDTO.getId() +","+ownerDTO.getPetId());
		}

		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);

	}

	@Override
	public OwnerDTO findOwner( OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);

		if (Objects.isNull(owner)) {
			throw new  OwnerPetCombinationNotFoundException ("Owner Not found wiht id " + primaryKey);
		}

		return MapperUtil.convertOwnerEntityToDto(owner);

	}
	
	
	@Override
	public void updatePetDetails(OwnerPetPrimaryKey primaryKey, String petName) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new  OwnerPetCombinationNotFoundException ("Owner Not found wiht id " + primaryKey);
		}
		ownerRepository.updatePetDetails(primaryKey, petName);
	}

	@Override
	public void deleteOwner(OwnerPetPrimaryKey primaryKey) throws OwnerPetCombinationNotFoundException {
		Owner owner = ownerRepository.findOwner(primaryKey);
		if (Objects.isNull(owner)) {
			throw new  OwnerPetCombinationNotFoundException ("Owner Not found wiht id " + primaryKey);
		}
		ownerRepository.deleteOwner(primaryKey);
	}

}
