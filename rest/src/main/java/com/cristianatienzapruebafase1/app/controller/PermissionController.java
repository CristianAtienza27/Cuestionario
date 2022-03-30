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
import com.cristianatienzapruebafase1.app.dto.PermissionDTO;
import com.cristianatienzapruebafase1.app.entity.Permission;
import com.cristianatienzapruebafase1.app.service.PermissionService;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

  @Autowired
  PermissionService permissionService;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Permission permission) {
    Permission newPermission = permissionService.save(permission);
    LOGGER.info("permission created: " + newPermission.getTitle());
    return ResponseEntity.status(HttpStatus.CREATED).body(newPermission);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value = "id") Long permissionId) {
    Optional<Permission> permission = permissionService.findById(permissionId);

    if (!permission.isPresent()) {
      LOGGER.warn("permission not found");
      return ResponseEntity.notFound().build();
    }

    LOGGER.info("permission retrieved: " + permission.get().getTitle());

    return ResponseEntity
        .ok(permissionService.transformPermissionToPermissionDTO(permission.get()));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody Permission permission,
      @PathVariable(value = "id") Long permissionId) {

    if (!permissionService.findById(permissionId).isPresent()) {
      LOGGER.warn("permission not found");
      return ResponseEntity.notFound().build();
    }

    PermissionDTO permissionDTO =
        permissionService.transformPermissionToPermissionDTO(permissionService.save(permission));
    LOGGER.info("permission updated: " + permissionDTO.getTitle());
    return ResponseEntity.status(HttpStatus.CREATED).body(permissionDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long permissionId) {

    Optional<Permission> permission = permissionService.findById(permissionId);

    if (permission.isPresent()) {
      LOGGER.warn("permission not found");
      return ResponseEntity.notFound().build();
    }

    permissionService.delete(permissionId);
    LOGGER.warn("permission deleted: " + permission.get().getTitle());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public Page<Permission> readAllOrderByName(Pageable pageable) {
    pageable = PageRequest.of(0, 3, Sort.by("title"));
    return permissionService.findAll(pageable);
  }
}
