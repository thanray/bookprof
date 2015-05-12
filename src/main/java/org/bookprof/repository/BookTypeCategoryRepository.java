package org.bookprof.repository;

import org.bookprof.model.book.BookTypeCategory;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by kr on 13/05/15.
 */
public interface BookTypeCategoryRepository extends PagingAndSortingRepository <BookTypeCategory, ObjectId> {
}
