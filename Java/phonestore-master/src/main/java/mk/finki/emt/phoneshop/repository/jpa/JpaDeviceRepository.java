package mk.finki.emt.phoneshop.repository.jpa;

import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.model.Device;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaDeviceRepository extends JpaRepository<Device, Long> {

    //    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {"category", "manufacturer"})
    List<Device> findByCategoryId(Long id);

//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {"category", "manufacturer"})
    Optional<Device> findById(Long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"category", "manufacturer"})
    List<Device> findAll();

    List<Device> findByManufacturerNameLike(String manufacturer);


}
