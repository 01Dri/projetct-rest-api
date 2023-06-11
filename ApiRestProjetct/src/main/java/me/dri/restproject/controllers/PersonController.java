package me.dri.restproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dri.restproject.data.vo.v1.PersonVO;
import me.dri.restproject.data.vo.v2.PersonVOV2;
import me.dri.restproject.services.PersonServices;
import me.dri.restproject.utils.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping(value = "/person")
@Tag(name = "People", description = "Endpoints for Managing people")
public class PersonController {

    @Autowired
    private PersonServices services;


    @GetMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, value = "/{id}")
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

    @PutMapping (value = "/{id}", consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces =
           {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> update(@PathVariable Long id, @RequestBody PersonVO obj) {
        obj  = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, value = "/v2/{id}")
    public ResponseEntity<PersonVOV2> createV2(@RequestBody PersonVOV2 person) {
        person = services.create(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(person);

    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
    @Operation(summary = "Finds a Person", description = "Finds a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            }
    )
    public ResponseEntity<List<PersonVO>> findAll(){
        List<PersonVO> persons = services.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        services.delete(id);
    }
}
