package me.dri.restproject.controllers;


import me.dri.restproject.data.vo.v1.PersonVO;
import me.dri.restproject.data.vo.v2.PersonVOV2;
import me.dri.restproject.model.Person;
import me.dri.restproject.services.PersonServices;
import me.dri.restproject.utils.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServices services;


    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable Long id ) {
        PersonVO person = services.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
        person = services.create(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getKey()).toUri();
        return ResponseEntity.created(uri).body(person);

    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<PersonVO> update(@PathVariable Long id, @RequestBody PersonVO obj) {
        obj  = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping (value = "/v2")
    public ResponseEntity<PersonVOV2> create(@RequestBody PersonVOV2 person) {
        person = services.create(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(person);

    }

    @GetMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<List<PersonVO>> findAll(){
        List<PersonVO> persons = services.findAll();
        return ResponseEntity.ok().body(persons);
    }

}
