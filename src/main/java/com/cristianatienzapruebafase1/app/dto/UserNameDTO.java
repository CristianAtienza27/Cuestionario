package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserNameDTO implements Serializable{
  private static final long serialVersionUID = -825151165681376137L;

  private Long id;

  private String fullname;
  
  private String email;

  private Boolean enabled;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @JsonIgnore
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
  
  
  
  
}
