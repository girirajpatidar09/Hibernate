
package com.giriraj;

import java.util.List;
import java.util.Scanner;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.service.OwnerService;
import com.giriraj.service.impl.OwnerServiceImpl;
import com.giriraj.util.InputUtil;


public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();
	}

	public void run() {
		OwnerService ownerService = new OwnerServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					List<OwnerDTO> ownerDTOList = ownerService.findSelectedOwnersWithoutHql(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Primary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 2:
					ownerDTOList = ownerService.findSelectedOwnersWithoutHqlV2(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Secondary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 3:
					ownerDTOList = ownerService.findSelectedOwnersWithHql(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Primary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 4:
					ownerDTOList = ownerService.findSelectedOwnersWithHqlV2(List.of(10,20,10));
					System.out.println("There are " + ownerDTOList.size() + " owners with Secondary Caching enabled.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 5:
					ownerDTOList = ownerService.findAllOwners();
					System.out.println("There are " + ownerDTOList.size() + " owners.");
					ownerDTOList.forEach(System.out::println);
					break;
				default:
					System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
