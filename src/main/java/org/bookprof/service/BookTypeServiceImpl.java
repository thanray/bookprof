package org.bookprof.service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import java.util.Date;

import org.bookprof.model.book.BookType;
import org.bookprof.model.user.User;
import org.bookprof.repository.BookTypeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by kr on 13/05/15.
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {
  @Autowired
  private MongoTemplate template;
  @Autowired
  private BookTypeRepository bookTypeRepository;

  @Override
  public BookType getBookType(ObjectId id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void save(User user, BookType bookType) {
    assertNotNull(user, "user");
    assertNotNull(user.getId(), "user.id");
    assertNotNull(bookType, "bookType");

    Date now = new Date();

    if (bookType.getId() == null){
      bookType.setCreatedById(user);
      bookType.setCreatedByDateTime(now);
    }
    bookType.setUpdatedById(user);
    bookType.setUpdatedByDateTime(now);

    bookTypeRepository.save(bookType);
  }

}
