package mk.finki.ukim.mk.laboratoriska.service;


import mk.finki.ukim.mk.laboratoriska.model.Balloon;

import java.util.List;

public interface BalloonService {

    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

}
