package com.cristianatienzapruebafase1.app.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.cristianatienzapruebafase1.app.dto.UserNameDTO;
import com.cristianatienzapruebafase1.app.entity.User;
import com.cristianatienzapruebafase1.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  // Create an User
  @PostMapping
  public ResponseEntity<?> create(@RequestBody User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }
  

//  // Read an User
//  @GetMapping("/{id}")
//  public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
//    Optional<User> oUser = userService.findById(userId);
//
//    if (!oUser.isPresent()) {
//      return ResponseEntity.notFound().build();
//    }
//
//    return ResponseEntity.ok(oUser);
//  }
  
  // Read an User and return UserDTO
//  @GetMapping("/{id}")
//  public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
//    
//   Optional<User> user = userService.findById(userId);
//   
//   if (!user.isPresent()) {
//     return ResponseEntity.notFound().build();
//   }
//   
//   return ResponseEntity.ok(userService.transformUsertoUserDTO(user.get()));
//  }
  
  //Read an User and return UserNameDTO
  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value="id") Long userId){
    
   Optional<User> user = userService.findById(userId);
   
   if (!user.isPresent()) {
     return ResponseEntity.notFound().build();
   }
   
   UserNameDTO userNameDTO = userService.transformUserNametoUserNameDTO(user.get());
   userNameDTO.setFullname(user.get().getName() + ' ' + user.get().getSurname());
   
   return ResponseEntity.ok(userNameDTO);
  }
  
  
  

  // Update an User
  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody User userDetails,
      @PathVariable(value = "id") Long userId) {
    Optional<User> user = userService.findById(userId);

    if (!user.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    // BeanUtils.copyProperties(userDetails, user);

    user.get().setName(userDetails.getName());
    user.get().setSurname(userDetails.getSurname());
    user.get().setEmail(userDetails.getEmail());
    user.get().setEnabled(userDetails.getEnabled());

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

  }

  // Remove an User
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {

    if (!userService.findById(userId).isPresent()) {
      return ResponseEntity.notFound().build();
    }

    userService.delete(userId);
    return ResponseEntity.ok().build();
  }

  // Read all Users
<<<<<<< Updated upstream
  @GetMapping
  public List<User> readAll() {

    return StreamSupport.stream(userService.findAll().spliterator(), false)
        .collect(Collectors.toList());
=======
//  @GetMapping
//  public List<User> readAll() {
//
//    return StreamSupport.stream(userService.findAll().spliterator(), false)
//        .collect(Collectors.toList());
//  }
  
  @GetMapping
  public Page<User> readAllOrderByName(Pageable pageable){
    pageable = PageRequest.of(0, 3, Sort.by("name"));
    return userService.findAll(pageable);
>>>>>>> Stashed changes
  }
}
