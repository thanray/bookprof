package org.bookprof.model.rent;

import java.util.Date;

import org.bookprof.model.base.BaseModel;
import org.bookprof.model.book.Book;
import org.bookprof.model.user.User;

/**
 * Created by kr on 16/02/15.
 */
public class Rent extends BaseModel {
  private Long rentId;
  private RentType rentType;
  private User user;
  private Book book;

  private Date startDate;
  private Date endDate;
  private int nrOfPostPonds;

}
