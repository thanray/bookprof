package org.bookprof.repository.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by kr on 01/05/15.
 */
@NoRepositoryBean
public interface MyRepository <T, ObjectId extends Serializable> extends CrudRepository<T, ObjectId>{
  @Override
  <S extends T> S save(S entity);
}
