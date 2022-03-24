package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{
  
  private static final long serialVersionUID = -825151165681376137L;

  private Long id;

  private String name;

  private String surname;

  private String email;

  private Boolean enabled;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
  
  
}
