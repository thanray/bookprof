package org.bookprof.service;

import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Date;

import org.bookprof.IntegrationTestCase;
import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.BookTypeCategory;
import org.bookprof.model.book.Publisher;
import org.bookprof.repository.BookTypeCategoryRepository;
import org.bookprof.repository.BookTypeRepository;
import org.bookprof.repository.PublisherRepository;
import org.bson.types.ObjectId;
import org.junit.After;
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
  private BookTypeService bookTypeService;

  private BookTypeCategory category;
  private Publisher publisher;

  @After
  public void tearDown() {
    bookTypeRepository.deleteAll();
    bookTypeCategoryRepository.deleteAll();
    publisherRepository.deleteAll();
  }

  @Test
  public void testGetBookType()  {

  }
  @Test(expected = IllegalArgumentException.class)
  public void testSave()  {
    bookTypeService.save(null, null);
  }
  @Test
  public void testCreate()  {

    //Given
    ObjectId categoryObjectId = ObjectId.get();
    BookTypeCategory category = new BookTypeCategory(categoryObjectId, "category");
    bookTypeCategoryRepository.save(category);

    Publisher publisher = new Publisher(ObjectId.get(), "published");
    publisherRepository.save(publisher);

    Date now = new Date();
    BookType bookType = getBookType();

    // When
    bookTypeService.save(user, bookType);

    // Then
    assertNotNull("userId", user.getId());
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