package com.prueba.demo.Persistence;

import com.prueba.demo.Domain.MarvelUser;
import com.prueba.demo.Domain.Repository.MarvelUsersRepository;
import com.prueba.demo.Persistence.CRUD.MarvelCrudRepository;
import com.prueba.demo.Persistence.Entity.MarvelUsuarios;
import com.prueba.demo.Persistence.Mapper.MarvelUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MarvelUsuariosRepository implements MarvelUsersRepository {

    @Autowired
    private MarvelCrudRepository marvelCrudRepository;

    @Autowired
    private MarvelUsersMapper marvelUsersMapper;


    @Override
    public List<MarvelUser> getAll() {
        List<MarvelUsuarios> MarvelUsuarioss= (List<MarvelUsuarios>) marvelCrudRepository.findAll();
        return marvelUsersMapper.toMarvelUsers(MarvelUsuarioss);
    }

    @Override
    public Optional<MarvelUser> getRegister(int id) {
        return marvelCrudRepository.findById(id).map(MarvelUsuarios -> marvelUsersMapper.toMarvelUser(MarvelUsuarios));
    }

    @Override
    public String getOnlyOney(int id) { return "mensaje de prueba Marvel Usuarios " + id; }


    @Override
    public MarvelUser saveRegister(MarvelUser marvelUser) {
        MarvelUsuarios marvelUsuarios = marvelUsersMapper.toMarvelUsuarios(marvelUser);
        return marvelUsersMapper.toMarvelUser(marvelCrudRepository.save(marvelUsuarios));
    }
}
