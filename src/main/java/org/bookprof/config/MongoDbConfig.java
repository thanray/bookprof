package org.bookprof.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Profile("default")
@Configuration
@ComponentScan(value = "org.bookprof")
@EnableMongoRepositories(value = "org.bookprof.repository")
public class MongoDbConfig extends AbstractMongoConfiguration {

  Logger logger = LoggerFactory.getLogger(MongoDbConfig.class);

  public static void main(String[] args) {
    SpringApplication.run(MongoDbConfig.class, args);
  }

  @Value("${mongo.url}")
  private String url;

  @Value("${mongo.db}")
  private String databaseName;

  @Override
  protected String getDatabaseName() {

    logger.info("Using database:  " + databaseName);
    return databaseName;
  }

  @Override
  public Mongo mongo() throws Exception {
    MongoClient mongoClient = new MongoClient();

    return mongoClient;
  }

  @Override
  protected String getMappingBasePackage() {
    return "org.bookprof.model";
  }
}
