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
}
