package org.bookprof.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.bookprof.UnitTestCase;
import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.model.book.BookType;
import org.bookprof.model.book.Publisher;
import org.bookprof.repository.BookTypeRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookTypeControllerTest extends UnitTestCase {

  @Mock
  private BookTypeRepository bookTypeRepository;

  @InjectMocks
  private BookTypeController controller;

  @Override
  public Object getController() {
    controller = new BookTypeController();
    return controller;
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetBookTypes() throws Exception {
    // Given
    BookType bookType = getBookType();
    given(bookTypeRepository.findAll()).willReturn(Arrays.asList(bookType));

    // When and Then
    mockMvc.perform(MockMvcRequestBuilders.get("/bookTypes").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].ssn").value("12345"));
  }

  @Test
  public void testGetBookType() throws Exception {
    // Given

    BookType bookType = getBookType();
    given(bookTypeRepository.findOne(bookType.getId())).willReturn(bookType);

    // When and Then
    mockMvc.perform(MockMvcRequestBuilders.get("/bookTypes/" + bookType.getId().toString()).accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.ssn").value("12345"))
        .andExpect(jsonPath("$.id").value(bookType.getId().toString()));
  }

  public BookType getBookType() {
    return new BookTypeBuilder(ObjectId.get())
        .setSSN("12345")
        .setPublisher(new Publisher())
        .build();
  }

}