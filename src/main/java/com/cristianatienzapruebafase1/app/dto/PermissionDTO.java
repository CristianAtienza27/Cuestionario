package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;

public class PermissionDTO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private Long id;
  
  private String title;

  public PermissionDTO(Long id, String title) {
    super();
    this.id = id;
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  

}
