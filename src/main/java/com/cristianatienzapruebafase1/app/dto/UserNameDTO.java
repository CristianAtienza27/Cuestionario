package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserNameDTO implements Serializable{
  private static final long serialVersionUID = -825151165681376137L;

  private Long id;

  private String fullname;
  
  private String email;

  private Boolean enabled;

  
}