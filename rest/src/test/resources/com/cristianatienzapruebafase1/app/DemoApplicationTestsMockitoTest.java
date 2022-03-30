package com.cristianatienzapruebafase1.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.cristianatienzapruebafase1.app.controller.UserController;
import com.cristianatienzapruebafase1.app.service.UserService;


@WebMvcTest(controllers = UserController.class)
class DemoApplicationTestsMockitoTest {

  @MockBean
  private UserService userService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAllUsersWithRolWithoutRolPermissions() throws Exception {
    mockMvc.perform(get("/api/users")).andExpect(status().is(200))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  void saveUser() throws Exception {
    String json = "{\n" + "  \"name\": \"Cristian\",\n" + "  \"surname\": \"Atienza\",\n"
        + "  \"email\": \"c@mail.com\",\n" + "  \"enabled\": true ,\n" + "  \"rol\": null \n" + "}";

    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated());
  }
}
