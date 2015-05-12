package org.bookprof.repository;

import java.util.List;

import org.bookprof.model.book.BookType;
import org.bookprof.model.book.Publisher;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by kr on 18/02/15.
 */

public interface BookTypeRepository extends PagingAndSortingRepository<BookType, ObjectId> {

  List<BookType> findByPublisher(Publisher publisher);
}
