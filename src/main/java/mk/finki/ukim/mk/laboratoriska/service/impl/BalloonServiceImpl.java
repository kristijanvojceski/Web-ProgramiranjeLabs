package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.repository.InMemoryBalloonRepository;
import mk.finki.ukim.mk.laboratoriska.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final InMemoryBalloonRepository balloonRepository;

    public BalloonServiceImpl(InMemoryBalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }
}
