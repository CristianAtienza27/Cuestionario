package com.cristianatienzapruebafase1.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cristianatienzapruebafase1.app.entity.Permission;
import com.cristianatienzapruebafase1.app.entity.Rol;
import com.cristianatienzapruebafase1.app.entity.User;
import com.cristianatienzapruebafase1.app.service.PermissionService;
import com.cristianatienzapruebafase1.app.service.RolService;
import com.cristianatienzapruebafase1.app.service.UserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DemoApplicationTests {

  @Autowired
  PermissionService permissionService;

  @Autowired
  RolService rolService;

  @Autowired
  UserService userService;

  @Test
  @Order(1)
  void testSavePermission() {
    Permission permission = permissionService.save(new Permission(1L, "add"));
    assertTrue(permissionService.findById(permission.getId()).isPresent());
  }

  @Test
  @Order(2)
  void testSaveRol() {
    List<Permission> permissions = new ArrayList<>();
    permissions.add(permissionService.findById(1L).get());

    Rol rol = rolService.save(new Rol(1L, "user", permissions));

    assertEquals(1L, rolService.findById(rol.getId()).get().getId());
  }

  @Test
  @Order(3)
  void testSaveUser() {    
    Rol rol = rolService.findById(1L).get();
    User user = new User(1L, "Cristian", "Atienza", "cristian@gmail.com", true, rol);
    userService.save(user);
    
    assertTrue(userService.findById(user.getId()).isPresent());
  }
  
  @Test
  @Order(4)
  void testUpdateUser() {
    User user = userService.findById(1L).get();
    user.setSurname("Rodriguez");
    
    user = userService.save(user);
    
    assertEquals("Rodriguez", user.getSurname());
  }
  
  @Test
  @Order(5)
  void testAllUsersWithRolAndWithoutRolPermissions() {
    Rol rol = rolService.findById(1L).get();
    rol.setPermissions(null);
    rolService.save(rol);
    
    Iterable<User> users = userService.findAllWithRolWithoutPermissions();
    assertEquals(1, StreamSupport.stream(users.spliterator(), false).count());
  }
  
  @Test
  @Order(6)
  void testDelete() {
    userService.delete(1L);
    assertTrue(!userService.findById(1L).isPresent());
  }
  
  

}
