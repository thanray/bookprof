package org.bookprof.model.store;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by kr on 21/03/15.
 */
public class StoreEntry {
  @Id
  ObjectId id;

  String shelf;

  String note;
}
