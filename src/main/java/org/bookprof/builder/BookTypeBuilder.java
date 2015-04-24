package org.bookprof.builder;

import java.util.Date;
import java.util.List;

import org.bookprof.model.book.Author;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.BookTypeCategory;
import org.bookprof.model.book.Publisher;
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

  public BookTypeBuilder setName(String name){
    bookType.setName(name);
    return this;
  }
  public BookTypeBuilder setSSN(String ssn){
    bookType.setSSN(ssn);
    return this;
  }
  public BookTypeBuilder setInternalId(String internalId){
    bookType.setInternalId(internalId);
    return this;
  }

  public BookTypeBuilder setReleasedDate(Date releasedDate){
    bookType.setReleasedDate(releasedDate);
    return this;
  }

  public BookTypeBuilder setBookTypeCategory(List<BookTypeCategory> bookTypeCategories){
    bookType.setBookTypeCategory(bookTypeCategories);
    return this;
  }

  public BookTypeBuilder  setAuthor(Author author){
    bookType.setAuthor(author);
    return this;
  }
  public BookTypeBuilder setPublisher(Publisher publisher){
    bookType.setPublisher(publisher);
    return this;
  }

  public BookTypeBuilder setYear(int year){
    bookType.setYear(year);
    return this;
  }

  public BookTypeBuilder setPage(int page){
    bookType.setPage(page);
    return this;
  }

  public BookTypeBuilder setNr(int nr){
    bookType.setNr(nr);
    return this;
  }

  public BookTypeBuilder setShelf(String shelf){
    bookType.setShelf(shelf);
    return this;
  }

  @Override
  public BookType getInstance() {
    return bookType;
  }
}