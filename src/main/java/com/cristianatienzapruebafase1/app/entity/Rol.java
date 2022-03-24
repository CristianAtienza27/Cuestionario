package com.cristianatienzapruebafase1.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column(length=50)
  private String name;
  
  @ManyToMany
  @JoinTable(name = "rol_permissions",
      joinColumns = @JoinColumn(name = "rol_id"),
      inverseJoinColumns = @JoinColumn(name = "permissions_id"))
  private List<Permission> permissions = new ArrayList<>();
  
  @OneToMany(mappedBy="rol", orphanRemoval=true)
  List<User> users = new ArrayList<>();
 
  
  public Rol() {
    super();
  }

  public Rol(Long id, String name, List<Permission> permissions) {
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
