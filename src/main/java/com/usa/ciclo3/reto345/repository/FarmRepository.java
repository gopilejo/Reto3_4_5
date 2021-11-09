package com.usa.ciclo3.reto345.repository;

import java.util.List;
import java.util.Optional;


import com.usa.ciclo3.reto345.crudrepository.FarmCrudRepository;
import com.usa.ciclo3.reto345.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author USUARIO
 */
@Repository
public class FarmRepository {


    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farm> getAll(){

        return (List<Farm>) farmCrudRepository.findAll();
    }

    public Optional<Farm> getFarm(int id){

        return farmCrudRepository.findById(id);
    }

    public Farm save(Farm farm){

        return farmCrudRepository.save(farm);
    }
    public void delete(Farm farm){

        farmCrudRepository.delete(farm);
    }

}
