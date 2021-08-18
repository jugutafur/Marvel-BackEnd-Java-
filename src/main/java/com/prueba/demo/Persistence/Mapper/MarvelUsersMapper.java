package com.prueba.demo.Persistence.Mapper;

import com.prueba.demo.Domain.MarvelUser;
import com.prueba.demo.Persistence.Entity.MarvelUsuarios;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MarvelUsersMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "identificacion", target = "identification"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "clave", target = "password")
    })
    MarvelUser toMarvelUser (MarvelUsuarios marvelUsuarios);
    List<MarvelUser> toMarvelUsers(List<MarvelUsuarios> marvelUsuarios);

    @InheritInverseConfiguration
    MarvelUsuarios toMarvelUsuarios(MarvelUser marvelUser);
}
