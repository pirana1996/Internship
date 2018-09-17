package com.sorsix.angular.angulartutorial;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

    List<Hero> heroes = Arrays.asList(
            new Hero(11, "Mr. Kote"),
            new Hero(12, "Mr. Robot"),
            new Hero(13, "Kamikazi"),
            new Hero(14, "RubberMan")
    );

    @GetMapping("/api/heroes")
    public List<Hero> getHeroes(){
        return heroes;
    }

    @GetMapping("/api/heroes/{id}")
    public Hero getHero(@PathVariable int id){
        return heroes.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
//        for(int i=0; i<heroes.size(); i++)
//            if(heroes.get(i).getId() == id)
//                return heroes.get(i);
//        return null;
    }
}
