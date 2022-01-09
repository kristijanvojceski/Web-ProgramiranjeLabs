package mk.finki.ukim.mk.laboratoriska.repository.jpa;

import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long>{
}
