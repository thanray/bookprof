package org.bookprof.repository;

import org.bookprof.model.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by kr on 18/02/15.
 */

public interface BookRepository extends MongoRepository<Book, Long> {


}
