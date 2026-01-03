
package com.giriraj;

import java.util.List;
import java.util.Scanner;

import com.giriraj.dto.OwnerDTO;
import com.giriraj.dto.PetDTO;
import com.giriraj.service.OwnerService;
import com.giriraj.service.PetService;
import com.giriraj.service.impl.OwnerServiceImpl;
import com.giriraj.service.impl.PetServiceImpl;
import com.giriraj.util.InputUtil;


public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.run();
	}

	public void run() {
		OwnerService ownerService = new OwnerServiceImpl();
		PetService petService = new PetServiceImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					OwnerDTO ownerDTO = ownerService.findOwner(ownerId);
					System.out.println("Owner has been fetched successfully.");
					System.out.println(ownerDTO);
					break;
				case 2:
					int petId = InputUtil.acceptPetIdToOperate(scanner);
					PetDTO petDTO = petService.findPet(petId);
					System.out.println("Pet has been fetched successfully.");
					System.out.println(petDTO);
					break;
				case 3:
					List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
					System.out.println("There are " + ownerDTOList.size() + " owners.");
					ownerDTOList.forEach(System.out::println);
					break;
				case 4:
					List<PetDTO> petDTOList = petService.findAllPets();
					System.out.println("There are " + petDTOList.size() + " pets.");
					petDTOList.forEach(System.out::println);
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
