package org.bookprof.service;

import java.util.List;

import org.bookprof.model.book.Author;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.Publisher;
import org.bookprof.model.user.User;
import org.bson.types.ObjectId;

/**
 * Created by kr on 13/05/15.
 */
public interface BookTypeService {

  BookType getBookType(ObjectId id);

  void save(User user, BookType bookType);

  List<BookType> getBookTypeByAuthor(User user, Author author);

  List<BookType> getBookTypeByPublisher(User user, Publisher publisher);


}
