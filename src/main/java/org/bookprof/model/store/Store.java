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

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStorePhone() {
    return storePhone;
  }

  public void setStorePhone(String storePhone) {
    this.storePhone = storePhone;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
