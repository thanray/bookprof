package org.bookprof.repository;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by kr on 12/04/15.
 */
//@ConfigurationProperties(prefix = "itest")
public class MongoDBTest {

  @Value("${mongo-db}")
  String mongoDb;


}
