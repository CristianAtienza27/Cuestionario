package com.cristianatienzapruebafase1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cristianatienzapruebafase1.app.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
