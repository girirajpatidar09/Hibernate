package com.giriraj.service.impl;

import java.util.Objects;
import java.util.UUID;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.entity.Owner;
import com.giriraj.exception.OwnerNotFoundException;
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
	public OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));

		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not found wiht id " + ownerId);
		}

		return MapperUtil.convertOwnerEntityToDto(owner);

	}
	
	
	@Override
	public void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not found wiht id " + ownerId);
		}
		ownerRepository.updatePetDetails(UUID.fromString(ownerId), petName);
	}

	@Override
	public void deleteOwner(String  ownerId) throws OwnerNotFoundException {
		Owner owner = ownerRepository.findOwner(UUID.fromString(ownerId));
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException("Owner Not found wiht id " + ownerId);
		}
		ownerRepository.deleteOwner(UUID.fromString(ownerId));
	}

}
