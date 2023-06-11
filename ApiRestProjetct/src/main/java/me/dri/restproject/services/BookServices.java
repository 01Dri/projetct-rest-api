package me.dri.restproject.services;


import me.dri.restproject.controllers.BookController;
import me.dri.restproject.controllers.PersonController;
import me.dri.restproject.data.vo.v1.BooksVO;
import me.dri.restproject.exception.ResourceNotFoundDb;
import me.dri.restproject.mapper.DozerMapper;
import me.dri.restproject.mapper.custom.BooksMapper;
import me.dri.restproject.model.Books;
import me.dri.restproject.model.Person;
import me.dri.restproject.repositories.BooksRepository;
import me.dri.restproject.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    @Autowired
    private BooksRepository booksRepository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public BooksVO findById(Long id) {
        var entity = booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundDb("No database book"));
        BooksVO booksVO = DozerMapper.parseObj(entity, BooksVO.class);
        booksVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return  booksVO;
    }

    public BooksVO create(BooksVO booksVO) {
        var entity = DozerMapper.parseObj(booksVO, Books.class);
        return DozerMapper.parseObj(booksRepository.save(entity), BooksVO.class);
    }
    public List<BooksVO> findAll() {
        logger.info("Searching books");
        var entity = booksRepository.findAll();
        if (entity.isEmpty()) {
            throw  new ResourceNotFoundDb("No database books");
        }
        List<BooksVO> booksVOS = DozerMapper.parseListObj(entity, BooksVO.class);
        booksVOS.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return booksVOS;

    }
}
