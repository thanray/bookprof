package org.bookprof.builder;

/**
 * Created by kr on 10/03/15.
 */
public abstract class BaseModelBuilder <B> {

  public B build() {
    return getInstance();
  }

  public abstract B getInstance();
}
