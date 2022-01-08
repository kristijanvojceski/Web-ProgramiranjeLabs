package mk.finki.ukim.mk.laboratoriska.service;


import mk.finki.ukim.mk.laboratoriska.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {

    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);
    Optional<Balloon> add(String name,String description,Long manufacturerId);
    Optional<Balloon> edit(Long id,String name,String description,Long manufacturerId);
    void deleteById(Long id);

}
