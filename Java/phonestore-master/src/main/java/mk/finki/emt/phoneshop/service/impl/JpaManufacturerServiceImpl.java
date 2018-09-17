package mk.finki.emt.phoneshop.service.impl;

import mk.finki.emt.phoneshop.model.Manufacturer;
import mk.finki.emt.phoneshop.repository.jpa.JpaManufacturerRepository;
import mk.finki.emt.phoneshop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile("jpa")
public class JpaManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private JpaManufacturerRepository repo;

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return Optional.of(repo.getOne(id));
    }

    @Override
    public Manufacturer findOne(Long id) {
        return repo.getOne(id);
    }

    @Override
    public Collection<Manufacturer> findAll() {
        return repo.findAll();
    }

    @Override
    public Manufacturer save(Manufacturer entity) {
        return repo.save(entity);
    }
}
