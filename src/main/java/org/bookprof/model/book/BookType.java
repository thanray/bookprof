package org.bookprof.model.book;

import java.util.Date;
import java.util.List;

import org.bookprof.model.base.BaseModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kr on 16/02/15.
 */

@Document
public class BookType extends BaseModel {

  @Id
  private ObjectId id;

  @Indexed
  private String name;
  private String ssn;
  private String internalId;
  private Date releasedDate;

  @DBRef
  private List<BookTypeCategory> bookTypeCategory;

  @DBRef
  private Author author;
  private Publisher publisher;
  private int year;
  private int page;
  private int nr;
  private String shelf;


  public BookType() {
  }

  public BookType(ObjectId id) {
    this.id = id;
  }

  public ObjectId getId(){
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

  public String getSsn() {
    return ssn;
  }

  public void setSSN(String ssn) {
    this.ssn = ssn;
  }

  public String getInternalId() {
    return internalId;
  }

  public void setInternalId(String internalId) {
    this.internalId = internalId;
  }

  public Date getReleasedDate() {
    return releasedDate;
  }

  public void setReleasedDate(Date releasedDate) {
    this.releasedDate = releasedDate;
  }

  public List<BookTypeCategory> getBookTypeCategory() {
    return bookTypeCategory;
  }

  public void setBookTypeCategory(List<BookTypeCategory> bookTypeCategory) {
    this.bookTypeCategory = bookTypeCategory;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getYear() {
    return year;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPage() {
    return page;
  }

  public void setNr(int nr) {
    this.nr = nr;
  }

  public int getNr() {
    return nr;
  }

  public void setShelf(String shelf) {
    this.shelf = shelf;
  }

  public String getShelf() {
    return shelf;
  }
}
