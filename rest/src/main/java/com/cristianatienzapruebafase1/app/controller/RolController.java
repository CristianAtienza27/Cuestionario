package com.cristianatienzapruebafase1.app.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cristianatienzapruebafase1.app.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RolController.class);

  @Autowired
  RolService rolService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Rol rol) {
    Rol newRol = rolService.save(rol);
    LOGGER.info("rol created: " + rol.getName());
    return ResponseEntity.status(HttpStatus.CREATED).body(newRol);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value = "id") Long rolId) {
    Optional<Rol> rol = rolService.findById(rolId);

    if (!rolService.findById(rolId).isPresent()) {
      LOGGER.warn("rol not found");
      return ResponseEntity.notFound().build();
    }

    RolDTO rolDTO = rolService.transformRoltoRolDTO(rol.get());
    LOGGER.info("rol retrieved: " + rol.get().getName());
    return ResponseEntity.ok(rolDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody Rol rol, @PathVariable(value = "id") Long rolId) {

    if (!rolService.findById(rolId).isPresent()) {
      LOGGER.warn("rol not found");
      return ResponseEntity.notFound().build();
    }

    RolDTO rolDTO = rolService.transformRoltoRolDTO(rolService.save(rol));
    LOGGER.info("rol update: " + rolDTO.getName());
    return ResponseEntity.status(HttpStatus.CREATED).body(rolDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long rolId) {

    Optional<Rol> rol = rolService.findById(rolId);

    if (rol.isPresent()) {
      LOGGER.warn("rol not found");
      return ResponseEntity.notFound().build();
    }

    rolService.delete(rolId);
    LOGGER.info("rol update: " + rol.get().getName());
    return ResponseEntity.ok().build();
  }

  // Read all User OrderByName and Paginate
  @GetMapping
  public Page<Rol> readAllOrderByName(Pageable pageable) {
    pageable = PageRequest.of(0, 3, Sort.by("name"));
    return rolService.findAll(pageable);
  }
}

