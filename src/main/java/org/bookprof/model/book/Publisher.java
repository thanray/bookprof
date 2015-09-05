package org.bookprof.model.book;

import org.bookprof.model.base.BaseModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by kr on 22/03/15.
 */
public class Publisher extends BaseModel {

  @Id
  private ObjectId id;

  @Indexed
  private String name;

  public Publisher() {
  }

  public Publisher(ObjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  public Publisher(String publisherName) {
    this.name = publisherName;
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
