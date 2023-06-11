package me.dri.restproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dri.restproject.data.vo.v1.BooksVO;
import me.dri.restproject.services.BookServices;
import me.dri.restproject.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/books")
@Tag(name = "Books", description = "Endpoints for Managing books")
public class BookController {


    @Autowired
    private BookServices services;


    @GetMapping(
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML  })
    @Operation(summary = "Finds a Books", description = "Finds a Book",
            tags = {"Books"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BooksVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            }
    )
    public ResponseEntity<List<BooksVO>> findAll() {
        List<BooksVO> books = services.findAll();
        return ResponseEntity.ok().body(books);

    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<BooksVO> findById(@PathVariable Long id) {
        var entity = services.findById(id);
        return ResponseEntity.ok().body(entity);
    }
}
