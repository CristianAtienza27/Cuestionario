package com.cristianatienzapruebafase1.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission implements Serializable{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  
  private String title;
  
  @ManyToMany(mappedBy = "permissions")
  private List<Rol> roles = new ArrayList<>();


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

  public List<Rol> getRoles() {
    return roles;
  }

  public void setRoles(List<Rol> roles) {
    this.roles = roles;
  }
  
  
  
}
