package org.bookprof.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.bookprof.config.MongoDbConfig;
import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.config.WebMvcConfig;
import org.bookprof.model.book.BookType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by kr on 04/03/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoDbConfig.class, WebMvcConfig.class})
@WebAppConfiguration
public class BookTypeRepositoryTest {

  Logger logger = LoggerFactory.getLogger(BookTypeRepositoryTest.class);

  @Autowired
  private BookTypeRepository bookTypeRepository;

  @Before
  public void setUp() {

    bookTypeRepository.deleteAll();
    BookType newBookType = (BookType) new BookTypeBuilder()
        .setName("En god dag").build();

    bookTypeRepository.save(newBookType);
  }

  @Test
  public void testFindAll() {

    BookType bookType = getFirstFromDb();

    assertEquals("En god dag", bookType.getName());
    assertNotNull(bookType.getId());
  }

  private BookType getFirstFromDb() {
    Iterable<BookType> all = bookTypeRepository.findAll();

    return all.iterator().next();
  }

  @Test
  public void testDeleteById() {

    BookType firstFromDb = getFirstFromDb();
    bookTypeRepository.delete(firstFromDb);

    BookType one = bookTypeRepository.findOne(firstFromDb.getId().toString());
    assertNull(one);
  }
  @Test
  public void testGetById() {

    BookType firstFromDb = getFirstFromDb();

    BookType one = bookTypeRepository.findOne(firstFromDb.getId().toString());
    assertNotNull(one);
    assertEquals(firstFromDb.getId(), one.getId());
  }
  @Test
  public void testUpdate() {

    BookType firstFromDb = getFirstFromDb();
    firstFromDb.setName("New name of the book");
    BookType one = bookTypeRepository.save(firstFromDb);

    assertNotNull(one);
    assertEquals(firstFromDb.getId(), one.getId());
    assertEquals("New name of the book", one.getName());
  }
}
