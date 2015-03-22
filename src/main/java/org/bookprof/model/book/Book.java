package org.bookprof.model.book;

import org.apache.catalina.Store;
import org.bookprof.model.base.BaseModel;
import org.bookprof.model.store.StoreEntry;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kr on 16/02/15.
 */
@Document
public class Book extends BaseModel{

  @Id
  private ObjectId bookId;

  private Store store;
  private BookType bookType;
  private StoreEntry storeEntry;
  private String desc;
  private int expNr;

  // rentNr

  public ObjectId getBookId() {
    return bookId;
  }

  public void setBookId(ObjectId bookId) {
    this.bookId = bookId;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  public BookType getBookType() {
    return bookType;
  }

  public void setBookType(BookType bookType) {
    this.bookType = bookType;
  }

  public StoreEntry getStoreEntry() {
    return storeEntry;
  }

  public void setStoreEntry(StoreEntry storeEntry) {
    this.storeEntry = storeEntry;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getExpNr() {
    return expNr;
  }

  public void setExpNr(int expNr) {
    this.expNr = expNr;
  }

}
