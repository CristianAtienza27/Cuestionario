package com.cristianatienzapruebafase1.app.dto;

import java.io.Serializable;
import java.util.List;
import com.cristianatienzapruebafase1.app.entity.Permission;
import lombok.Data;

@Data
public class RolDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private List<Permission> permissions;

  public RolDTO() {
    super();
  }

  public RolDTO(String name, List<Permission> permissions) {
    super();
    this.name = name;
    this.permissions = permissions;
  }

  public RolDTO(Long id, String name, List<Permission> permissions) {
    super();
    this.id = id;
    this.name = name;
    this.permissions = permissions;
  }

}
