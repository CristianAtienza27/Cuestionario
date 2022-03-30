package com.cristianatienzapruebafase1.app.servicesImpl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cristianatienzapruebafase1.app.dto.PermissionDTO;
import com.cristianatienzapruebafase1.app.entity.Permission;
import com.cristianatienzapruebafase1.app.repository.PermissionRepository;
import com.cristianatienzapruebafase1.app.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{
  
  @Autowired
  PermissionRepository permissionRepository;

  @Override
  public Permission transformPermissionDTOtoPermission(PermissionDTO permissionDTO) {
    return new ModelMapper().map(permissionDTO, Permission.class);
  }

  @Override
  public PermissionDTO transformPermissionToPermissionDTO(Permission permission) {
    return new ModelMapper().map(permission, PermissionDTO.class);
  }

  @Override
  public Iterable<Permission> findAll() {
    return permissionRepository.findAll();
  }

  @Override
  public Page<Permission> findAll(Pageable pageable) {
    return permissionRepository.findAll(pageable);
  }

  @Override
  public Optional<Permission> findById(Long id) {
    return permissionRepository.findById(id);
  }

  @Override
  public Permission save(Permission permission) {
    return permissionRepository.save(permission);
  }

  @Override
  public void delete(Long id) {
      permissionRepository.deleteById(id);
  }

}
