package com.shahab.mateAcademy.SpringBoot.controller;


import com.shahab.mateAcademy.SpringBoot.EventNotFoundException;
import com.shahab.mateAcademy.SpringBoot.dao.EventDao;
import com.shahab.mateAcademy.SpringBoot.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class EventController {

    @Autowired
    private EventDao eventDao;

    @GetMapping("/events")
    public List<Event> retrieveAllEvents() {
        return eventDao.findAll();
    }




    @PostMapping("/events")
    public ResponseEntity<Object> createEvent(@Valid @RequestBody Event event) {
        Event savedEvent = eventDao.save(event);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEvent.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/events/{id}")
    public Resource<Event> retrieveEvent(@PathVariable int id) {
        Event event = eventDao.findOne(id);

        if(event==null)
            throw new EventNotFoundException("id-"+ id);

        Resource<Event> resource = new Resource<Event>(event);

        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllEvents());

        resource.add(linkTo.withRel("all-events"));


        return resource;
    }


}
