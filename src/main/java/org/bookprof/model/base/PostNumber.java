package org.bookprof.model.base;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kr on 16/02/15.
 */
@Document
public class PostNumber {

  @Id
  private ObjectId postId;
  @Indexed
  private Integer code;
  @Indexed
  private String name;
}
