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
  private ObjectId id;

  @Indexed
  private String name;

  public Author() {
  }

  public Author(String name) {
    this.name = name;
  }

  public Author(ObjectId objectId, String name) {
    this.name = name;
    this.id = id;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
