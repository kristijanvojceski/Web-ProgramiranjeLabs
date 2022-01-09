package mk.finki.ukim.mk.laboratoriska.repository.jpa;

import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon,Long> {

    List<Balloon> findAllByNameAndDescription(String name, String description);

}
