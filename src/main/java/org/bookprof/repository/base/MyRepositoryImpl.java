package org.bookprof.repository.base;

import java.io.Serializable;
import java.util.Date;

import org.bookprof.model.base.BaseModel;
import org.bookprof.model.user.User;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

/**
 * Created by kr on 01/05/15.
 */
public class MyRepositoryImpl <T extends BaseModel, ObjectId extends Serializable> extends SimpleMongoRepository<T, ObjectId> implements MyRepository<T,ObjectId> {

  /**
   * Creates a ew {@link org.springframework.data.mongodb.repository.support.SimpleMongoRepository} for the given {@link org.springframework.data.mongodb.repository.query.MongoEntityInformation} and {@link MongoTemplate}.
   *
   * @param metadata        must not be {@literal null}.
   * @param mongoOperations
   */
  public MyRepositoryImpl(MongoEntityInformation<T, ObjectId> metadata, MongoOperations mongoOperations) {
    super(metadata, mongoOperations);
  }

  public <S extends T>void save(User createdBy, S s){
    s.setUpdatedByDateTime(new Date());
    s.setUpdatedById(createdBy);
    s.setCreatedByDateTime(new Date());
    s.setCreatedById(createdBy);

    super.save(s);
  }
}
