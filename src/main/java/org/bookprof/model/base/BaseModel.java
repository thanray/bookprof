package org.bookprof.model.base;

import java.util.Date;

import org.bookprof.model.user.User;

/**
 * Created by kr on 16/02/15.
 */
public abstract class BaseModel {

  private boolean enabled;
  private long createdById;
  private User updatedById;

  private Date createdByDateTime;
  private Date updatedByDateTime;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public long getCreatedById() {
    return createdById;
  }

  public void setCreatedById(long createdById) {
    this.createdById = createdById;
  }

  public User getUpdatedById() {
    return updatedById;
  }

  public void setUpdatedById(User updatedById) {
    this.updatedById = updatedById;
  }

  public Date getCreatedByDateTime() {
    return createdByDateTime;
  }

  public void setCreatedByDateTime(Date createdByDateTime) {
    this.createdByDateTime = createdByDateTime;
  }

  public Date getUpdatedByDateTime() {
    return updatedByDateTime;
  }

  public void setUpdatedByDateTime(Date updatedByDateTime) {
    this.updatedByDateTime = updatedByDateTime;
  }
}
