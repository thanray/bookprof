package org.bookprof.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.bookprof.builder.BookTypeBuilder;
import org.bookprof.config.CustomJacksonConfig;
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
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class BookTypeControllerTestCase {

  private MockMvc mockMvc;

  @Mock
  private BookTypeRepository bookTypeRepository;

  @InjectMocks
  private BookTypeController controller = new BookTypeController();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(controller);
    standaloneMockMvcBuilder.setMessageConverters(new CustomJacksonConfig().mappingJackson2HttpMessageConverter());
    mockMvc = standaloneMockMvcBuilder.build();
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
    mockMvc.perform(MockMvcRequestBuilders.get("/bookTypes/"+bookType.getId().toString()).accept(MediaType.APPLICATION_JSON))
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