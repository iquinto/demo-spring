package com.example.demospring.repository;

import com.example.demospring.model.Musician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MusicianRepository extends CrudRepository<Musician, Long> {

    Musician findByName(String name);

}
