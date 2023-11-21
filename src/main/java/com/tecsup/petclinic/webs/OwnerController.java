package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.mapper.OwnerMapper;
import com.tecsup.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OwnerController {

    // Iniciando AutoWired

    private OwnerService ownerService;

    private OwnerMapper mapper;
    /**
     *  Change
     * @param ownerService
     * @param mapper
     */

    public OwnerController(OwnerService ownerService, OwnerMapper mapper) {
        this.ownerService =ownerService;
        this.mapper = mapper;
    }

    /**
     * Update and create pet
     *
     * @param ownerTO
     * @param id
     * @return
     */

    // Mapenado para actualizar owner
    @PutMapping(value = "/owners/{id}")
    ResponseEntity<OwnerTO> update(@RequestBody OwnerTO ownerTO, @PathVariable int id) {

        OwnerTO updateOwnerTO = null;

        try {

            // Llamando al service pet para llamar el método update
            Owner updateOWner = ownerService.findById(id);

            // Recogiendo las nuevas datas
            updateOWner.setFirst_name(ownerTO.getFirst_name());
            updateOWner.setLast_name(ownerTO.getLast_name());
            updateOWner.setAddress(ownerTO.getAddress());
            updateOWner.setCity(ownerTO.getCity());
            updateOWner.setTelephone(ownerTO.getTelephone());

            // Llamando a petservice para traer metodo actualizar
             ownerService.update(updateOWner);

             updateOwnerTO = this.mapper.toOwnerTO(updateOWner);

        } catch (OwnerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateOwnerTO);
    }


}
