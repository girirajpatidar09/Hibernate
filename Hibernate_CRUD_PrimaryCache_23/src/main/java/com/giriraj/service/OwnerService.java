
package com.giriraj.service;

import java.util.List;

import com.giriraj.dto.OwnerDTO;


public interface OwnerService {
	List<OwnerDTO> findSelectedOwnersWithoutHql(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithoutHqlV2(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithHql(List<Integer> ownerIdList);

	List<OwnerDTO> findSelectedOwnersWithHqlV2(List<Integer> ownerIdList);
}
