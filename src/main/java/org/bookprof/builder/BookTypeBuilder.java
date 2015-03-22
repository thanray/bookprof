package org.bookprof.builder;

import org.bookprof.model.book.BookType;
import org.bson.types.ObjectId;

public class BookTypeBuilder extends BaseModelBuilder <BookType> implements Builder {

  private BookType bookType;

  public BookTypeBuilder() {
    bookType = new BookType();
  }

  public BookTypeBuilder(String bookTypeId) {
    bookType = new BookType();
    bookType.setId(new ObjectId(bookTypeId));
  }

  public Builder setName(String name){
    bookType.setName(name);
    return this;
  }

  @Override
  public BookType getInstance() {
    return bookType;
  }
}