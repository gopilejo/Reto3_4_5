package com.usa.ciclo3.reto345.web;


import java.util.List;
import java.util.Optional;


import com.usa.ciclo3.reto345.model.Farm;
import com.usa.ciclo3.reto345.services.FarmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class FarmController {

    @Autowired
    private FarmServices farmServices;

    @GetMapping("/all")
    public List<Farm> getFarm(){

        return farmServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getFarm(@PathVariable("id") int id) {

        return farmServices.getFarm(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm farm) {

        return farmServices.save(farm);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)

    public Farm update(@RequestBody Farm farm) {

        return farmServices.update(farm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return farmServices.deleteFarm(id);
    }


}
