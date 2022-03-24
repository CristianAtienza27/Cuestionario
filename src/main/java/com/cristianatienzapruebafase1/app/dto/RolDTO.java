package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.cristianatienzapruebafase1.app.entity.Permission;

public class RolDTO implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private Long id;
  
  private String name;
  
  private List<Permission> permissions;
  
  public RolDTO() {
    super();
  }

  public RolDTO(Long id, String name, List<Permission> permissions) {
    super();
    this.id = id;
    this.name = name;
    this.permissions = permissions;
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

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }
  
  

}
