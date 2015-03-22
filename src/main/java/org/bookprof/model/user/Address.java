package org.bookprof.model.user;

import org.bookprof.model.base.PostNumber;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by kr on 16/02/15.
 */


public class Address {

  private Long addressId;
  private String street;

  @DBRef
  private PostNumber postNumber;

}
