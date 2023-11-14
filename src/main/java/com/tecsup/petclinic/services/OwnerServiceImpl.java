package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService {

    OwnersRepository ownersRepository;

    public OwnerServiceImpl (OwnersRepository ownersRepository) {

        this.ownersRepository = ownersRepository;
    }

    // Creacion de owner
    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner create(Owner owner) {
        return ownersRepository.save(owner);
    }

    /**
     *
     * @param owner
     * @return
     */
    @Override
    public Owner update(Owner owner) {
        return ownersRepository.save(owner);
    }

    /**
     *
     * @param id
     * @throws OwnerNotFoundException
     */
    @Override
    public void delete(Integer id) throws OwnerNotFoundException {
        Owner owner = findById(id);
        ownersRepository.delete(owner);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Owner findById(int id) throws OwnerNotFoundException {

        Optional<Owner> owner = ownersRepository.findById(id);

        if ( !owner.isPresent())
            throw new OwnerNotFoundException("Record not found..!");
        return owner.get();
    }

    /**
     *
     * @param first_name
     * @return
     */

}
