package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import com.cristianatienzapruebafase1.app.entity.Rol;

public class UserDTO implements Serializable{
  
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

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }
  
  
  
  
}
