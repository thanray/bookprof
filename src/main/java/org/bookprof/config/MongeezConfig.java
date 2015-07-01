package org.bookprof.config;

import org.mongeez.MongeezRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by kr on 04/06/15.
 */
@Profile("default")
@Configuration
public class MongeezConfig extends MongoDbConfig {

  @Value("${mongo.url}")
  private String url;

  @Value("${mongo.db}")
  private String databaseName;

  Logger logger = LoggerFactory.getLogger(MongeezConfig.class);

  @Bean
  public MongeezRunner getMongeezRunner() throws Exception {
    logger.info("initializing mongeez, databaseName:" + databaseName);

    MongeezRunner runner = new MongeezRunner();
    runner.setMongo(mongo());
    runner.setDbName(databaseName);
    runner.setFile(new ClassPathResource("mongeez/mongeez.xml"));
    runner.setExecuteEnabled(true);

    logger.info("initializing mongeez: finished");
    return runner;
  }



}
