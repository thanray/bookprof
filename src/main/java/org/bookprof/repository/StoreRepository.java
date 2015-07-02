package org.bookprof.repository;


import org.bookprof.model.store.Store;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kr on 25/04/15.
 */

public interface StoreRepository extends CrudRepository<Store, ObjectId> {
}
