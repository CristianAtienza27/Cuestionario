package com.cristianatienzapruebafase1.app.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column(length=50)
  private String name;
  
  @OneToMany(mappedBy="rol", orphanRemoval=true)
  List<User> users = new ArrayList<>();

  public Rol() {
    super();
  }

  public Rol(Long id, String name) {
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
