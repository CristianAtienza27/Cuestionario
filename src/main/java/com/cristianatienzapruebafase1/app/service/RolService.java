package com.cristianatienzapruebafase1.app.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cristianatienzapruebafase1.app.dto.RolDTO;
import com.cristianatienzapruebafase1.app.entity.Rol;

public interface RolService {
  public Rol transformRolDTOtoRol(RolDTO rolDTO);
  
  public RolDTO transformRoltoRolDTO(Rol rol);

  public Iterable<Rol> findAll();

  public Page<Rol> findAll(Pageable pageable);

  public Optional<Rol> findById(Long id);

  public Rol save(Rol rol);

  public void delete(Long id);
}
