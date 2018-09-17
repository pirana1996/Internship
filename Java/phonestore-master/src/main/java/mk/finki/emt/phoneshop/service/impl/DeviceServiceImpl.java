package mk.finki.emt.phoneshop.service.impl;

import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.repository.jpa.JpaDeviceRepository;
import mk.finki.emt.phoneshop.repository.mock.DeviceRepository;
import mk.finki.emt.phoneshop.repository.mock.impl.DeviceRepositoryImpl;
import mk.finki.emt.phoneshop.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private JpaDeviceRepository repo;

    @Override
    public Optional<Device> findById(Long id) {
        return Optional.of(repo.getOne(id));
    }

    @Override
    public Device findOne(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Collection<Device> findAll() {
       return repo.findAll();
    }

    @Override
    public Device save(Device entity) {
        return repo.save(entity);
    }

    @Override
    public List<Device> findByCategoryId(Long id) {
        return repo.findByCategoryId(id);
    }

    @Override
    public List<Device> findByManufacturerNameLike(String name) {
        return repo.findByManufacturerNameLike(name);
    }
}
