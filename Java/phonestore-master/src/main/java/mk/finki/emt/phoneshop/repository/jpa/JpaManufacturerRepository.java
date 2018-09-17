package mk.finki.emt.phoneshop.repository.jpa;

import mk.finki.emt.phoneshop.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
