package org.bookprof.model.book;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by kr on 22/03/15.
 */
public class Publisher {

  @Id
  private ObjectId publisherId;

  @Indexed
  private String name;

  public Publisher(String name) {
    this.name = name;
  }
}
