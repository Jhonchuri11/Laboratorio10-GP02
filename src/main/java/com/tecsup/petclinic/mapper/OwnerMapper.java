package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.OwnerTO;
import com.tecsup.petclinic.entities.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Mapping(source = "address", target = "address")
    OwnerTO toOwnerTO(Owner owner);

}
