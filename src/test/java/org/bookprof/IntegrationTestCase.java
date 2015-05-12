package org.bookprof;

import java.util.Date;

import org.bookprof.config.DefaultConfig;
import org.bookprof.model.user.User;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by kr on 12/04/15.
 */
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = { DefaultConfig.class }, loader = SpringApplicationContextLoader.class)
public class IntegrationTestCase {

  public static final Date now = new Date();

  @Autowired
  protected MongoTemplate template;

  protected User user = new User();

  @Before
  public void setUp(){

    template.save(user);
  }
}

