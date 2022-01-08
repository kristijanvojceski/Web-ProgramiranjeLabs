package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.laboratoriska.repository.InMemoryBalloonRepository;
import mk.finki.ukim.mk.laboratoriska.repository.InMemoryManufacturerRepository;
import mk.finki.ukim.mk.laboratoriska.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final InMemoryBalloonRepository balloonRepository;
    private final InMemoryManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(InMemoryBalloonRepository balloonRepository,InMemoryManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public Optional<Balloon> add( String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(()->new ManufacturerNotFoundException(manufacturerId));
        return this.balloonRepository.add(name,description,manufacturer);
    }

    @Override
    public Optional<Balloon> edit(Long id, String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(()->new ManufacturerNotFoundException(manufacturerId));
        return this.balloonRepository.add(name,description,manufacturer);
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }
}
