package org.bookprof.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bookprof.model.book.BookType;
import org.bookprof.repository.BookTypeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kr on 16/02/15.
 */
@RestController
@RequestMapping(value = "bookTypes")
public class BookTypeController {

  @Autowired
  private BookTypeRepository bookTypeRepository;

  @RequestMapping(method = {RequestMethod.GET})
  public List<BookType> getBookTypes() {
    List<BookType> bookTypes = new ArrayList<BookType>();

    Iterable<BookType> all = bookTypeRepository.findAll();

    return toBookTypeList(bookTypes, all);
  }

  private List<BookType> toBookTypeList(List<BookType> bookTypes, Iterable<BookType> all) {
    for (BookType bookType : all){
      bookTypes.add(bookType);
    }

    return bookTypes;
  }


  @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
  public List<BookType> getBookType(@PathVariable String id) {
    List<BookType> bookTypes = new ArrayList<BookType>();

    ObjectId objectId =  new ObjectId(id);
    Iterable<BookType> all = bookTypeRepository.findAll(Arrays.asList(objectId));

    return toBookTypeList(bookTypes, all);
  }

  @RequestMapping(method = {RequestMethod.PUT})
  public void createBookType(BookType bookType){
    assert bookType != null;
  }

}
