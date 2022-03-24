package com.cristianatienzapruebafase1.app.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cristianatienzapruebafase1.app.dto.RolDTO;
import com.cristianatienzapruebafase1.app.entity.Rol;
import com.cristianatienzapruebafase1.app.entity.User;
import com.cristianatienzapruebafase1.app.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

  @Autowired
  RolService rolService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Rol rol) {
    return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value = "id") Long rolId) {
    Optional<Rol> rol = rolService.findById(rolId);

    if (!rolService.findById(rolId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    RolDTO rolDTO = rolService.transformRoltoRolDTO(rol.get());

    return ResponseEntity.ok(rolDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody Rol rol, @PathVariable(value = "id") Long rolId) {

    if (!rolService.findById(rolId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    RolDTO rolDTO = rolService.transformRoltoRolDTO(rolService.save(rol));

    return ResponseEntity.status(HttpStatus.CREATED).body(rolDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long rolId) {

    if (!rolService.findById(rolId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    rolService.delete(rolId);
    return ResponseEntity.ok().build();
  }
  
  // Read all User OrderByName and Paginate
  @GetMapping
  public Page<Rol> readAllOrderByName(Pageable pageable){
    pageable = PageRequest.of(0, 3, Sort.by("name"));
    return rolService.findAll(pageable);
  }
}

