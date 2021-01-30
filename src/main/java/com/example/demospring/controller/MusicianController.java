package com.example.demospring.controller;

import com.example.demospring.model.Musician;
import com.example.demospring.service.MusicianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping(value = "/musicians")
public class MusicianController {

    private static final Logger log = LoggerFactory.getLogger(MusicianController.class);

    @Autowired
    MusicianService musicianService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Musician> musicianList = musicianService.findAll();
        model.addAttribute("musicianList", musicianList);
        return "musician/list";
    }



    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable @NotNull Long id, Model model) {

        log.info("[m:show] find musician with id " + id);
        Musician musician = musicianService.get(id);
        log.info("[m:show] musician found " + musician);
        model.addAttribute("musician", musician);

        return "musician/show";
    }



}
