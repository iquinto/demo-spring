package com.example.demospring.service;

import com.example.demospring.model.Musician;
import com.example.demospring.repository.MusicianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope(value = "singleton")
@Component(value = "musicianService")
public class MusicianService {

    @Autowired
    private MusicianRepository musicianRepository;

    private static final Logger log = LoggerFactory.getLogger(MusicianService.class);


    public List<Musician> findAll() {
        Iterable<Musician> iterator = musicianRepository.findAll();
        List<Musician> musicianList = new ArrayList<Musician>();
        iterator.forEach(musicianList::add);
        return musicianList;
    }

    public Musician get(Long id) {
        Musician musician = musicianRepository.findById(id).get();
        log.info("[m:get] musician found " + musician);
        return musician;
    }

    public Musician findByName(String name) {
        Musician musician =  musicianRepository.findByName(name);
        log.info("[m:findByName] musician found " + musician);
        return musician;
    }

    public Musician save(Musician musician) {
        log.info("[m:put] saving new musician: " + musician);
        Musician musicianPersisted = musicianRepository.save(musician);
        return musicianPersisted;
    }

}
