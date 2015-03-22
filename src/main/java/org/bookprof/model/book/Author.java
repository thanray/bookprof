package org.bookprof.model.book;

import org.bookprof.model.base.BaseModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by kr on 21/03/15.
 */
public class Author extends BaseModel {

  @Id
  private ObjectId authorId;

  @Indexed
  private String name;

  public Author(String name) {
    this.name = name;
  }
}
