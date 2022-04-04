package com.cristianatienzapruebafase1.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

// EJERCICIO 7.1

@Entity
@Table(name = "roles")
@Data
public class Rol implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String name;
  
  // EJERCICIO 7.6

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name = "rol_permissions", joinColumns = @JoinColumn(name = "rol_id"),
      inverseJoinColumns = @JoinColumn(name = "permissions_id"))
  private List<Permission> permissions = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "rol", orphanRemoval = true)
  private List<User> users = new ArrayList<>();


  public Rol() {
    super();
  }

  public Rol(String name, List<Permission> permissions) {
    super();
    this.name = name;
    this.permissions = permissions;
  }

  public Rol(Long id, String name, List<Permission> permissions) {
    super();
    this.id = id;
    this.name = name;
    this.permissions = permissions;
  }

}
