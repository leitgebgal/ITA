package um.feri.ita.userservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import um.feri.ita.userservice.dto.UserRecord;
import um.feri.ita.userservice.rest.UserController;
import um.feri.ita.userservice.service.UserService;
import um.feri.ita.userservice.vao.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    void testGetUsers() throws Exception {
        User user1 = new User("test1Name", "test1LastName", "test1@test.com", "test123");
        User user2 = new User("test2Name", "test2LastName", "test2@test.com", "test456");

        when(userService.getUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"firstName\":\"test1Name\", \"lastName\":\"test1LastName\", \"email\":\"test1@test.com\", \"password\":\"test123\"}, {\"firstName\":\"test2Name\", \"lastName\":\"test2LastName\", \"email\":\"test2@test.com\", \"password\":\"test456\"}]"));
    }

    @Test
    void testGetUserById() throws Exception {
        String id = "1";
        User user = new User("Test", "User", "test@test.com", "password");
        when(userService.getUserById(id)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":\"Test\", \"lastName\":\"User\", \"email\":\"test@test.com\", \"password\":\"password\"}"));
    }

    @Test
    void testCreateUser() throws Exception {
        User user = new User("Test", "User", "test@test.com", "password");
        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Test\", \"lastName\":\"User\", \"email\":\"test@test.com\", \"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":\"Test\", \"lastName\":\"User\", \"email\":\"test@test.com\"}"));
    }

    @Test
    void testUpdateUser() throws Exception {
        String id = "1";
        User updatedUser = new User("Updated", "User", "updated@test.com", "password");
        when(userService.updateUser(anyString(), any(User.class))).thenReturn(Optional.of(updatedUser));

        mockMvc.perform(put("/api/users/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Updated\", \"lastName\":\"User\", \"email\":\"updated@test.com\", \"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\":\"Updated\", \"lastName\":\"User\", \"email\":\"updated@test.com\"}"));
    }

    @Test
    void testDeleteUser() throws Exception {
        String id = "1";
        when(userService.getUserById(id)).thenReturn(Optional.of(new User()));
        when(userService.deleteUser(id)).thenReturn(true);

        mockMvc.perform(delete("/api/users/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("User with ID 1 successfully deleted."));
    }

    @Test
    void testDeleteUserNotFound() throws Exception {
        String id = "1";
        when(userService.getUserById(id)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/users/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("User with ID 1 not found for deletion."));
    }
}
