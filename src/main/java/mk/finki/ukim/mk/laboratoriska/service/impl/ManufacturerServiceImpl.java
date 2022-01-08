package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
import mk.finki.ukim.mk.laboratoriska.repository.InMemoryManufacturerRepository;
import mk.finki.ukim.mk.laboratoriska.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
