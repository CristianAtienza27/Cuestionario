package com.cristianatienzapruebafase1.app.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cristianatienzapruebafase1.app.dto.UserDTO;
import com.cristianatienzapruebafase1.app.dto.UserNameDTO;
import com.cristianatienzapruebafase1.app.entity.User;

public interface UserService {
  
  public User transformUserDTOtoUser(UserDTO userDTO);
  
  public UserDTO transformUsertoUserDTO(User user);
  
  public User transformUserNameDTOtoUserDTO(UserNameDTO userDTO);
  
  public UserNameDTO transformUserNametoUserNameDTO(User user);

  public Iterable<User> findAll();

  public Page<User> findAll(Pageable pageable);

  public Optional<User> findById(Long id);

  public User save(User user);

  public void delete(Long id);
}
