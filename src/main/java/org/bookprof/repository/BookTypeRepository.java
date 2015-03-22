package org.bookprof.repository;

import org.bookprof.model.book.BookType;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by kr on 18/02/15.
 */

public interface BookTypeRepository extends PagingAndSortingRepository<BookType, String> {


}
