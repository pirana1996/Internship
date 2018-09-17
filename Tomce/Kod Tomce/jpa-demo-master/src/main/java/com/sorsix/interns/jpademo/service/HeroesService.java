package com.sorsix.interns.jpademo.service;

import com.sorsix.interns.jpademo.model.Hero;
import com.sorsix.interns.jpademo.repository.HeroesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HeroesService {

    private static final Logger logger = LoggerFactory.getLogger(HeroesService.class);

    private final HeroesRepository repository;

    public HeroesService(HeroesRepository repository) {
        this.repository = repository;
    }

    public List<Hero> getHeroes() {
        return repository.findAll();
    }

    public Optional<Hero> getHero(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Hero createHero(String name) {
        Hero hero = new Hero(name);
        logger.info("Creating hero [{}]", hero);
        return repository.save(hero);
    }

    @Transactional
    public Optional<Hero> updateHero(Long id, String name) {
        Optional<Hero> hero = repository.findById(id);
        return hero.map(it -> {
            it.setName(name);
            logger.info("Updating hero [{}]", hero);
            return it;
        });
    }

    public void deleteHero(Long id) {
        logger.info("Deleting hero [{}]", id);
        repository.deleteById(id);
    }
}
