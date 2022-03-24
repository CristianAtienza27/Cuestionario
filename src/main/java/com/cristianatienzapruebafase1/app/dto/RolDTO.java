package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private Long id;
  
  private String name;
  
 
  public RolDTO() {
    super();
  }

  public RolDTO(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

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
  
}