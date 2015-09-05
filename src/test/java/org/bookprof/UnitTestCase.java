package org.bookprof;

import org.bookprof.config.CustomJacksonConfig;
import org.junit.Before;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by kr on 09/07/15.
 */
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public abstract class UnitTestCase {

  protected MockMvc mockMvc;

  public abstract Object getController();

  @Before
  public void initialize() {
    mockMvc = MockMvcBuilders.standaloneSetup(getController())
        .setMessageConverters(new CustomJacksonConfig().mappingJackson2HttpMessageConverter())
        .build();
  }
}
