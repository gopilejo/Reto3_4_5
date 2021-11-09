package com.usa.ciclo3.reto345.services;



import com.usa.ciclo3.reto345.model.Farm;
import com.usa.ciclo3.reto345.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmServices {

    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll(){

        return farmRepository.getAll();
    }

    public Optional<Farm> getFarm(int id) {

        return farmRepository.getFarm(id);
    }

    public Farm save(Farm farm){
        if(farm.getId()==null){
            return farmRepository.save(farm);
        }else{
            Optional<Farm> e= farmRepository.getFarm(farm.getId());
            if(e.isEmpty()){
                return farmRepository.save(farm);
            }else{
                return farm;
            }
        }
    }

    public Farm update(Farm farm){
        if(farm.getId()!=null){
            Optional<Farm> e= farmRepository.getFarm(farm.getId());
            if(!e.isEmpty()){
                if(farm.getName()!=null){
                    e.get().setName(farm.getName());
                }
                if(farm.getAddress()!=null){
                    e.get().setAddress(farm.getAddress()); ;
                }
                if(farm.getExtension() !=null){
                    e.get().setExtension(farm.getExtension());
                }
                if(farm.getDescription()!=null){
                    e.get().setDescription(farm.getDescription());
                }
                if(farm.getCategory()!=null){
                    e.get().setCategory(farm.getCategory());
                }
                farmRepository.save(e.get());
                return e.get();
            }else{
                return farm;
            }
        }else{
            return farm;
        }
    }


    public boolean deleteFarm(int id) {
        Boolean aBoolean = getFarm(id).map(farm -> {
            farmRepository.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}


