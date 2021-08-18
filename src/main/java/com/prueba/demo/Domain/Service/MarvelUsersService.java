package com.prueba.demo.Domain.Service;

import com.prueba.demo.Domain.MarvelUser;
import com.prueba.demo.Domain.Repository.MarvelUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarvelUsersService {

    @Autowired
    private MarvelUsersRepository marvelUsersRepository;

    public List<MarvelUser> getAll(){return marvelUsersRepository.getAll(); }
    public Optional<MarvelUser> getRegister(int id){ return  marvelUsersRepository.getRegister(id); }
    public String getOnlyOney(int id){return marvelUsersRepository.getOnlyOney(id); }
    public MarvelUser saveRegister(MarvelUser marvelUser){return marvelUsersRepository.saveRegister(marvelUser); }
}
