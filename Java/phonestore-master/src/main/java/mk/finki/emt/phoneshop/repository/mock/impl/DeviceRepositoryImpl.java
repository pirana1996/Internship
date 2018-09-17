package mk.finki.emt.phoneshop.repository.mock.impl;

import mk.finki.emt.phoneshop.model.Device;
import mk.finki.emt.phoneshop.repository.mock.DeviceRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DeviceRepositoryImpl implements DeviceRepository {

    static Map<Long,Device> map = new HashMap<>();
    static Long idSequence = 0l;
    @Override
    public Collection<Device> findAll() {
        return map.values();
    }

    @Override
    public Optional<Device> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public Device save(Device device) {
        if (device.getId()==null) {
            device.setId(getNextId());
        }
        map.put(device.getId(),device);
        return device;
    }

    private synchronized Long getNextId() {
        return ++idSequence;
    }
}
