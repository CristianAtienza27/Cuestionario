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
import com.cristianatienzapruebafase1.app.dto.PermissionDTO;
import com.cristianatienzapruebafase1.app.entity.Permission;
import com.cristianatienzapruebafase1.app.service.PermissionService;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

  @Autowired
  PermissionService permissionService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Permission permission) {
    return ResponseEntity.status(HttpStatus.CREATED).body(permissionService.save(permission));
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value = "id") Long permissionId) {
    Optional<Permission> permission = permissionService.findById(permissionId);

    if (!permission.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity
        .ok(permissionService.transformPermissionToPermissionDTO(permission.get()));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody Permission permission,
      @PathVariable(value = "id") Long permissionId) {

    if (!permissionService.findById(permissionId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    PermissionDTO permissionDTO =
        permissionService.transformPermissionToPermissionDTO(permissionService.save(permission));

    return ResponseEntity.status(HttpStatus.CREATED).body(permissionDTO);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long permissionId) {

    if (!permissionService.findById(permissionId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    permissionService.delete(permissionId);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping
  public Page<Permission> readAllOrderByName(Pageable pageable){
    pageable = PageRequest.of(0, 3, Sort.by("title"));
    return permissionService.findAll(pageable);
  }
}
