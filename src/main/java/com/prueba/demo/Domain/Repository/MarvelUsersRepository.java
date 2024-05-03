package com.prueba.demo.Domain.Repository;

import com.prueba.demo.Domain.MarvelUser;
import java.util.List;
import java.util.Optional;

public interface MarvelUsersRepository {
    List<MarvelUser> getAll();
    Optional<MarvelUser> getRegister(int id);
    MarvelUser saveRegister(MarvelUser marvelUser);
    void delete(int marvelId);
}
