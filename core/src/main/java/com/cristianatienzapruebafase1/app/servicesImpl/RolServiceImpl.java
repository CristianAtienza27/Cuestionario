package com.cristianatienzapruebafase1.app.servicesImpl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cristianatienzapruebafase1.app.dto.RolDTO;
import com.cristianatienzapruebafase1.app.entity.Rol;
import com.cristianatienzapruebafase1.app.repository.RolRepository;
import com.cristianatienzapruebafase1.app.service.RolService;

// EJERCICIO 7.2
@Service
public class RolServiceImpl implements RolService{
  
  @Autowired
  RolRepository rolRepository;

  @Override
  public Rol transformRolDTOtoRol(RolDTO rolDTO) {
    return new ModelMapper().map(rolDTO, Rol.class);
  }

  @Override
  public RolDTO transformRoltoRolDTO(Rol user) {
    return new ModelMapper().map(user, RolDTO.class);
  }

  @Override
  @Transactional(readOnly=true)
  public Iterable<Rol> findAll() {
    return rolRepository.findAll();
  }

  @Override
  public Page<Rol> findAll(Pageable pageable) {
    return rolRepository.findAll(pageable);
  }

  @Override
  public Optional<Rol> findById(Long id) {
    return rolRepository.findById(id);
  }

  @Override
  public Rol save(Rol rol) {
    return rolRepository.save(rol);
  }

  @Override
  public void delete(Long id) {
    rolRepository.deleteById(id);
  }
  
}
