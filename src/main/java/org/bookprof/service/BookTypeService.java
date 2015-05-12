package org.bookprof.service;

import org.bookprof.model.book.BookType;
import org.bookprof.model.user.User;
import org.bson.types.ObjectId;

/**
 * Created by kr on 13/05/15.
 */
public interface BookTypeService {

  BookType getBookType(ObjectId id);

  void save(User user, BookType bookType);

}
