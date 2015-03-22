package org.bookprof.model.rent;

/**
 * Created by kr on 16/02/15.
 */
public enum RentType
{
  REGULAR (30), EXPRESS(14), MEDIA(14);

  RentType(int days) {
    this.days = days;
  }

  int days;
}
