package org.bookprof.model.user;

import org.bookprof.model.base.BaseModel;

/**
 * Created by kr on 16/02/15.
 */
public class User extends BaseModel{


  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String mobilePhone;

  private Address address;

}
