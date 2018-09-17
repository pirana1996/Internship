package mk.finki.emt.phoneshop.repository.mock;

import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.repository.BaseRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Collection;
import java.util.List;

public interface DeviceRepository extends BaseRepository<Device,Long> {

}
