package com.example.demospring.controller;


import com.example.demospring.model.Musician;
import com.example.demospring.repository.MusicianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/rest")
public class RestAppController {


    @Autowired
    MusicianRepository musicianRepository;
    private static final Logger log = LoggerFactory.getLogger(RestAppController.class);


    @RequestMapping(value = "/musicians/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Musician> list() {
        List<Musician> musicianList = (List<Musician>) musicianRepository.findAll();
        log.info("[m:get] " + musicianList);

        return musicianList;
    }


}
