package org.bookprof.repository;

import org.bookprof.model.book.Publisher;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by kr on 25/04/15.
 */
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, ObjectId> {
}
