package com.cristianatienzapruebafase1.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cristianatienzapruebafase1.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public List<User> findByEnabled(Boolean isEnabled);
  
}
