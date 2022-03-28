package com.cristianatienzapruebafase1.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cristianatienzapruebafase1.app.customExceptions.ResourceNotFoundException;
import com.cristianatienzapruebafase1.app.entity.User;
import com.cristianatienzapruebafase1.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  // Create an User
  @PostMapping
  public ResponseEntity<?> create(@RequestBody User user) {

    User newUser = userService.save(user);
    LOGGER.info("user created: " + newUser.getName() + ' ' + newUser.getSurname());

    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  // Read an User
  @GetMapping("/{id}")
  public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
    Optional<User> oUser = Optional.ofNullable(userService.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId)));

    if (!oUser.isPresent()) {
      LOGGER.warn("user not found");
      return ResponseEntity.notFound().build();
    }

    LOGGER.info("user retrieved: " + oUser.get().getName() + ' ' + oUser.get().getSurname());
    return ResponseEntity.ok(oUser);
  }

  // Update an User
  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody User userDetails,
      @PathVariable(value = "id") Long userId) {
    Optional<User> user = userService.findById(userId);

    if (!user.isPresent()) {
      LOGGER.warn("user not found");
      return ResponseEntity.notFound().build();
    }

    // BeanUtils.copyProperties(userDetails, user);

    user.get().setName(userDetails.getName());
    user.get().setSurname(userDetails.getSurname());
    user.get().setEmail(userDetails.getEmail());
    user.get().setEnabled(userDetails.getEnabled());

    user = Optional.of(userService.save(user.get()));

    if (!user.isPresent()) {
      LOGGER.error("Error to update user");
    }

    LOGGER.info("user update: " + user.get().getName() + ' ' + user.get().getSurname());

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

  }

  // Remove an User
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {

    Optional<User> user = userService.findById(userId);

    if (!user.isPresent()) {
      LOGGER.warn("user not found");
      return ResponseEntity.notFound().build();
    }

    userService.delete(userId);
    LOGGER.info("User delete: " + user.get().getName() + ' ' + user.get().getSurname());

    return ResponseEntity.ok().build();
  }

  // Read all Users
  @GetMapping
  public List<User> readAll() {
    Iterable<User> users = userService.findAll();

    LOGGER.info("Users retrieved: " + users.spliterator().estimateSize());

    return StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
  }
}
