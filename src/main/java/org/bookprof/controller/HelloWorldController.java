package org.bookprof.controller;

import org.bookprof.model.book.BookType;
import org.bookprof.repository.BookTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloWorldController {

    @Autowired
    BookTypeRepository bookTypeRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        String str = "Hello World! 4";

        Iterable<BookType> all = bookTypeRepository.findAll();

        return str + "Has next? "+all.iterator().hasNext();
    }

}
