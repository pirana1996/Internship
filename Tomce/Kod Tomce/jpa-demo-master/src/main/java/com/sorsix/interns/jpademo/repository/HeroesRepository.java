package com.sorsix.interns.jpademo.repository;

import com.sorsix.interns.jpademo.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends JpaRepository<Hero, Long> {
}
