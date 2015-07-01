package org.bookprof.model.store;

import org.bookprof.model.user.Address;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by kr on 16/02/15.
 */
public class Store {

  @Id
  private ObjectId id;

  String name;
  String desc;
  String email;
  String storePhone;

  Address address;

}
