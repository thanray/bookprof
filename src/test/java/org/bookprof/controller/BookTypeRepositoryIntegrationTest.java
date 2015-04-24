package org.bookprof.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Date;

import org.bookprof.RepositoryIntegrationTest;
import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.BookTypeCategory;
import org.bookprof.model.book.Publisher;
import org.bookprof.repository.BookTypeRepository;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookTypeRepositoryIntegrationTest extends RepositoryIntegrationTest {

  @Autowired
  private BookTypeRepository bookTypeRepository;
  private Publisher publisher;
  private BookTypeCategory category;
  private Date now;

  @After
  public void tearDown() {
    bookTypeRepository.deleteAll();
  }

  @Before
  public void setUp() {
    category = new BookTypeCategory(ObjectId.get(), "category");
    publisher = new Publisher(ObjectId.get(), "published");
    now = new Date();
    BookType bookType = (BookType) new BookTypeBuilder()
        .setName("bookName")
        .setShelf("shelf")
        .setPage(100)
        .setYear(2015)
        .setPublisher(publisher)
        .setBookTypeCategory(Collections.singletonList(category))
        .setReleasedDate(now)
        .setSSN("ssn")
        .build();

    bookTypeRepository.save(bookType);
  }

  @Test
  public void testGetBookType() throws Exception {

    Iterable<BookType> all = bookTypeRepository.findAll();
    assertTrue(all.iterator().hasNext());
    BookType bookType = all.iterator().next();
    assertEquals("bookName", bookType.getName());
    assertNotNull("id", bookType.getId());
    assertEquals("shelf", bookType.getShelf());
    assertEquals(100, bookType.getPage());
    assertEquals(2015, bookType.getYear());
    assertEquals(now, bookType.getReleasedDate());
    //assertEquals(category.getId(), bookType.getBookTypeCategory().get(0).getId());
    assertEquals(publisher.getId(), bookType.getPublisher().getId());
  }
}