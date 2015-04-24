package org.bookprof.model.book;

import org.bookprof.model.base.BaseModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by kr on 21/03/15.
 */
public class BookTypeCategory extends BaseModel{

  @Id
  private ObjectId id;

  private String name;

  public BookTypeCategory(ObjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  public BookTypeCategory(String name) {
    this.name = name;
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
