package com.sorsix.interns.jpademo.api;

import com.sorsix.interns.jpademo.model.Hero;
import com.sorsix.interns.jpademo.service.HeroesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroesController {

    private final HeroesService service;

    public HeroesController(HeroesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Hero> getHeroes() {
        return service.getHeroes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Long id) {
        return service.getHero(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hero createHero(@RequestBody String name) {
        return service.createHero(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable Long id, @RequestBody String name) {
        return service.updateHero(id, name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteHero(id);
    }

}
