package org.bookprof;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories(value = "org.bookprof.repository")
public class BookProfApplication extends AbstractMongoConfiguration {

  Logger logger = LoggerFactory.getLogger(BookProfApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(BookProfApplication.class, args);
  }


  @Override
  protected String getDatabaseName() {
    String databaseName = "bookprof-db";
    String property = System.getProperty("mongo-db");

    if (property != null){
      databaseName = property;
    }

    logger.info("Database:  " + databaseName);
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
