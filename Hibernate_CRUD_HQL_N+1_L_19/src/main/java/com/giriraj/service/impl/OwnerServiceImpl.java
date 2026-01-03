
package com.giriraj.service.impl;

import java.util.List;
import java.util.Objects;

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
			throw new OwnerNotFoundException("OWNER_NOT_FOUND" +ownerId);
		}
		return MapperUtil.convertOwnerEntityToDto(owner);
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners().stream().map(MapperUtil::convertOwnerEntityToDtoWithoutPet).toList();
	}
	
	@Override
	public List<OwnerDTO> findAllOwnersWithPet() {
		return ownerRepository.findAllOwnersWithPet().stream().map(MapperUtil::convertOwnerEntityToDto).toList();
	}
}
