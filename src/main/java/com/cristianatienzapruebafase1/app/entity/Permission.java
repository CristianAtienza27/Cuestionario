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
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name = "permissions")
@Data
public class Permission implements Serializable{

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  
  private String title;
  
  @JsonIgnore
  @ManyToMany(mappedBy = "permissions")
  private List<Rol> roles = new ArrayList<>();
  
  public Permission() {
    super();
  }

  public Permission(Long id, String title) {
    super();
    this.id = id;
    this.title = title;
  }
  
}
