package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnersRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	/*
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnertNotFoundException e) {
			fail(e.getMessage());
		}
		log.info("" + owner);

		assertEquals(NAME, owner.getName());

	}
	*/
	// Campos Tabla
	// id
	// first_name
	// last_name
	// address
	// city
	// telephone
	@Test
	public void testUpdateOwner() {

		String FIRST_NAME = "Betty";
		String LAST_NAME = "Davis";
		String ADDRESS = "638 Cardinal Ave.";
		String CITY = "Sun Prairie";
		String TELEPHONE = "6085551749";

		// Parte nuevo owner
		String UP_FIRST_NAME = "Betty Luz";
		String UP_LAST_NAME = "Davis Gonzales";
		String UP_ADDRESS = "563 Friendly St.";
		String UP_CITY = "Windsor Prueba";
		String UP_TELEPHONE = "6085553198";

		Owner owner = new Owner(FIRST_NAME,LAST_NAME, ADDRESS, CITY, TELEPHONE);

		// creacion de nuevo owner
		log.info(">" + owner);
		Owner ownerCreated = this.ownerService.create(owner);
		log.info(">>" + ownerCreated);

		// Update
		// ALmacena la informacion nuebva del owner
		ownerCreated.setFirst_name(UP_FIRST_NAME);
		ownerCreated.setLast_name(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);

		// Ejecutando actualizacion
		Owner updateOwner = this.ownerService.update(ownerCreated);
		log.info(">>>>" + updateOwner);

		// EXPECTED ACTUAL

		assertEquals(UP_FIRST_NAME, updateOwner.getFirst_name());
		assertEquals(UP_LAST_NAME, updateOwner.getLast_name());
		assertEquals(UP_ADDRESS, updateOwner.getAddress());
		assertEquals(UP_CITY, updateOwner.getCity());
		assertEquals(UP_TELEPHONE, updateOwner.getTelephone());
	}

	//




}
