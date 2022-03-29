package com.cristianatienzapruebafase1.app.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cristianatienzapruebafase1.app.dto.PermissionDTO;
import com.cristianatienzapruebafase1.app.entity.Permission;

public interface PermissionService {
  public Permission transformPermissionDTOtoPermission(PermissionDTO permissionDTO);
  
  public PermissionDTO transformPermissionToPermissionDTO(Permission permission);

  public Iterable<Permission> findAll();

  public Page<Permission> findAll(Pageable pageable);

  public Optional<Permission> findById(Long id);

  public Permission save(Permission permission);

  public void delete(Long id);
}
