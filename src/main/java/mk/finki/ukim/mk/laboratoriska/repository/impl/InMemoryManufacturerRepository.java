package mk.finki.ukim.mk.laboratoriska.repository.impl;

import mk.finki.ukim.mk.laboratoriska.bootstrap.DataHolder;
import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturersList;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturersList.stream().filter(r->r.getId().equals(id)).findFirst();
    }

}
