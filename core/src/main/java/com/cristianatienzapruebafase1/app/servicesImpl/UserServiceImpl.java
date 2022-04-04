package com.cristianatienzapruebafase1.app.servicesImpl;

import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cristianatienzapruebafase1.app.dto.UserDTO;
import com.cristianatienzapruebafase1.app.dto.UserNameDTO;
import com.cristianatienzapruebafase1.app.entity.User;
import com.cristianatienzapruebafase1.app.repository.UserRepository;
import com.cristianatienzapruebafase1.app.service.UserService;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  // EJERCICIO 6.3
  @Override
  public User transformUserDTOtoUser(UserDTO userDTO) {
    return new ModelMapper().map(userDTO, User.class);
  }

  @Override
  public UserDTO transformUsertoUserDTO(User user) {
    return new ModelMapper().map(user, UserDTO.class);
  }

  @Override
  public User transformUserNameDTOtoUserDTO(UserNameDTO userNameDTO) {
    return new ModelMapper().map(userNameDTO, User.class);
  }

  @Override
  public UserNameDTO transformUserNametoUserNameDTO(User user) {
    return new ModelMapper().map(user, UserNameDTO.class);
  }

  @Override
  @Transactional(readOnly = true)
  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }
  
  //EJERCICIO 6.1
  
  // Read an User and return UserDTO
//@GetMapping("/{id}")
//public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
//  
// Optional<User> user = userService.findById(userId);
// 
// if (!user.isPresent()) {
//   return ResponseEntity.notFound().build();
// }
// 
// return ResponseEntity.ok(userService.transformUsertoUserDTO(user.get()));
//}
  
  //EJERCICIO 6.2
  
//Read an User and return UserNameDTO
//  @GetMapping("/{id}")
//  public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
//    
//   Optional<User> user = userService.findById(userId);
//   
//   if (!user.isPresent()) {
//     return ResponseEntity.notFound().build();
//   }
//   
//   UserNameDTO userNameDTO = userService.transformUserNametoUserNameDTO(user.get());
//   userNameDTO.setFullname(user.get().getName() + ' ' + user.get().getSurname());
//   
//   return ResponseEntity.ok(userNameDTO);
//  }

  @Override
  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
  
//      EJERCICIO 2.1
  
//  @Override
//  @Transactional(readOnly = true)
//  public Iterable<User> findByEnabledFilterByName(User user) {
//    return userRepository.findByEnabled(true).stream().filter(us -> us.getName() == user.getName())
//        .collect(Collectors.toList());
//  }
  
//      EJERCICIO 2.2
  
//Read all User OrderByName and Paginate
//  @GetMapping
//  public Page<User> readAllOrderByName(Pageable pageable) {
//    pageable = PageRequest.of(0, 3, Sort.by("name"));
//    return userService.findAll(pageable);
//  }

  // EJERCICIO 7.7
  
  @Override
  public Iterable<User> findAllWithRolWithoutPermissions() {
    return userRepository.findAll().stream()
        .filter(user -> user.getRol() != null && user.getRol().getPermissions().isEmpty())
        .collect(Collectors.toList());
  }
}
