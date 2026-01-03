
package com.giriraj.service.impl;

import java.util.List;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.entity.Owner;
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
	public List<OwnerDTO> findSelectedOwnersWithoutHql(List<Integer> ownerIdList) {
		return ownerRepository.findSelectedOwnersWithoutHql(ownerIdList).stream()
				.map(MapperUtil::convertOwnerEntityToDto).toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithoutHqlV2(List<Integer> ownerIdList) {
		return ownerIdList.stream().map(ownerId -> {
			Owner owner = ownerRepository.findOwnerWithoutHql(ownerId);
			return MapperUtil.convertOwnerEntityToDto(owner);
		}).toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithHql(List<Integer> ownerIdList) {
		return ownerRepository.findSelectedOwnersWithHql(ownerIdList).stream().map(MapperUtil::convertOwnerEntityToDto)
				.toList();
	}

	@Override
	public List<OwnerDTO> findSelectedOwnersWithHqlV2(List<Integer> ownerIdList) {
		return ownerIdList.stream().map(ownerId -> {
			Owner owner = ownerRepository.findOwnerWithHql(ownerId);
			return MapperUtil.convertOwnerEntityToDto(owner);
		}).toList();
	}
}
