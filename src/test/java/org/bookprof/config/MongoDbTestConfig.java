package org.bookprof.config;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by kr on 24/04/15.
 */
@Profile("test")
@Configuration
public class MongoDbTestConfig extends MongoDbConfig{

  @Override
  public Mongo mongo() throws Exception {
    return new Fongo("Test db server").getMongo();
  }
}
