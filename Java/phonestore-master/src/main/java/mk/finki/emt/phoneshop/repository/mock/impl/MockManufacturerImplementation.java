package mk.finki.emt.phoneshop.repository.mock.impl;

import mk.finki.emt.phoneshop.model.Manufacturer;
import mk.finki.emt.phoneshop.repository.mock.MockManufacturerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Profile("mock")
@Component
public class MockManufacturerImplementation implements MockManufacturerRepository {

    private static Map<Long,Manufacturer> all = new HashMap<>();
    private static Long idSequencer = 0l;

    @Override
    public Collection<Manufacturer> findAll() {
        return all.values();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return Optional.ofNullable(all.get(id));
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getId()==null) {
            manufacturer.setId(getNextIdValue());
        }
        all.put(manufacturer.getId(),manufacturer);
        return manufacturer;
    }

    private synchronized Long getNextIdValue() {
        return ++idSequencer;
    }
}
