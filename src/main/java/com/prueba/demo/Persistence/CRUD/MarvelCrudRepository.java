package com.prueba.demo.Persistence.CRUD;

import com.prueba.demo.Persistence.Entity.MarvelUsuarios;
import org.springframework.data.repository.CrudRepository;

public interface MarvelCrudRepository extends CrudRepository<MarvelUsuarios, Integer> {
}
