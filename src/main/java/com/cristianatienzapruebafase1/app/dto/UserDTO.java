package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import com.cristianatienzapruebafase1.app.entity.Rol;
import lombok.Data;

@Data
public class UserDTO implements Serializable {

  private static final long serialVersionUID = -825151165681376137L;

  private Long id;

  private String name;

  private String surname;

  private String email;

  private Boolean enabled;

  private Rol rol;

  public UserDTO(Long id, String name, String surname, String email, Boolean enabled, Rol rol) {
    super();
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.enabled = enabled;
    this.rol = rol;
  }

}
