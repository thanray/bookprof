package org.bookprof.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.config.RestTestUtil;
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
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



//@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class BookTypeControllerTestCase  {

  private MockMvc mockMvc;

  @Mock
  private BookTypeRepository bookTypeRepository;

  @InjectMocks
  private BookTypeController controller = new BookTypeController();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

  }


  @Test
  public void testGetBookType() throws Exception {
    // Given
    BookType bookType = getBookType();
    given(bookTypeRepository.findAll()).willReturn(Arrays.asList(bookType));

    mockMvc.perform(MockMvcRequestBuilders.get("/bookTypes").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(RestTestUtil.MediaTypeJson));

        /*
        get("login").with(httpBasic("username", "password")).contentType(MediaType.TEXT_PLAIN)
            .andExpect(status().isOk());
    */
  }

  public BookType getBookType() {
    return new BookTypeBuilder(ObjectId.get().toString())
        .setSSN("ssn")
        .setPublisher(new Publisher())
        .build();

  }
}