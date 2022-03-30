package com.cristianatienzapruebafase1.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

  private static final long serialVersionUID = -825151165681376137L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String name;

  private String surname;

  @Column(name = "mail", nullable = false, length = 50, unique = true)
  private String email;

  private Boolean enabled;

  @ManyToOne
  @JoinColumn(name = "rol")
  private Rol rol;

  public User() {
    super();
  }

  public User(String name, String surname, String email, Boolean enabled, Rol rol) {
    super();
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.enabled = enabled;
    this.rol = rol;
  }

  public User(Long id, String name, String surname, String email, Boolean enabled, Rol rol) {
    super();
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.enabled = enabled;
    this.rol = rol;
  }

}
