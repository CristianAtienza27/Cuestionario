package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PermissionDTO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private Long id;
  
  private String title;

  public PermissionDTO(Long id, String title) {
    super();
    this.id = id;
    this.title = title;
  }

}
