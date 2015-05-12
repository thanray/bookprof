package org.bookprof.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.List;

import org.bookprof.IntegrationTestCase;
import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.model.book.Author;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.BookTypeCategory;
import org.bookprof.model.book.Publisher;
import org.bookprof.repository.BookTypeCategoryRepository;
import org.bookprof.repository.BookTypeRepository;
import org.bookprof.repository.PublisherRepository;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookTypeServiceImplIntegrationTest extends IntegrationTestCase {

  @Autowired
  private BookTypeRepository bookTypeRepository;
  @Autowired
  private BookTypeCategoryRepository bookTypeCategoryRepository;
  @Autowired
  private PublisherRepository publisherRepository;
  @Autowired
  private BookTypeService instance;

  private BookTypeCategory category;
  private Publisher publisher;
  private BookType bookType;
  private Author author;

  @After
  public void tearDown() {
    bookTypeRepository.deleteAll();
    bookTypeCategoryRepository.deleteAll();
    publisherRepository.deleteAll();

  }

  @Before
  public void setUp(){
    ObjectId categoryObjectId = ObjectId.get();
    BookTypeCategory category = new BookTypeCategory(categoryObjectId, "category");
    bookTypeCategoryRepository.save(category);

    publisher = new Publisher(ObjectId.get(), "published");
    publisherRepository.save(publisher);

    bookType = getBookType();
  }

  @Test
  public void testGetBookType()  {

  }
  @Test(expected = IllegalArgumentException.class)
  public void testSave()  {
    instance.save(null, null);
  }
  @Test
  public void testCreate()  {

    //Given  new BookType

    // When
    instance.save(user, bookType);

    // Then
    assertNotNull("userId", user.getId());
  }
  @Test
  public void testGetBookTypeByPublisher()  {

    //Given
    template.save(user);
    instance.save(user, bookType);

    // When
    List<BookType> bookTypes = instance.getBookTypeByPublisher(user, publisher);

    // Then
    assertNotNull("bookTypes", bookTypes);
    BookType bookTypeWithPublisher = bookTypes.get(0);
    assertEquals(bookTypeWithPublisher.getPublisher().getName(), publisher.getName());
  }

  //TODO
  @Test
  public void testGetBookTypeByAuthor()  {


  }

  private BookType getBookType() {
    return (BookType) new BookTypeBuilder()
        .setName("bookName")
        .setShelf("shelf")
        .setPage(100)
        .setYear(2015)
        .setPublisher(publisher)
        .setBookTypeCategory(Collections.singletonList(category))
        .setReleasedDate(now)
        .setSSN("ssn")
        .build();
  }
}