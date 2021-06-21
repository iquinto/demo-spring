package com.example.demospring.controller.rest;


import com.example.demospring.model.Musician;
import com.example.demospring.service.MusicianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/musician")
public class MusicianRestController {

    @Autowired
    MusicianService musicianService;
    private static final Logger log = LoggerFactory.getLogger(MusicianRestController.class);

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Musician> musicianList() {
        List<Musician> musicianList = musicianService.findAll();
        log.info("[m:musicianList] " + musicianList);

        return musicianList;
    }

    //http://localhost:8080/musicians/11
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Musician findById(@PathVariable @NotNull Long id) {
        log.info("[m:findById] " + id);
        Musician musician = musicianService.get(id);
        log.info("[m:findById] musician found: " + musician);
        return musician;
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Musician save(@RequestBody Musician musician, BindingResult result) {
        log.info("[m:save]  saving new musician: " + musician);
        Musician musicianPersisted = musicianService.save(musician);
        return musicianPersisted;
    }

}
