package um.feri.ita.userservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import um.feri.ita.userservice.dao.UserRepository;
import um.feri.ita.userservice.vao.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUsers() {
        User user1 = new User("Test", "User", "test1@test.com", "password");
        User user2 = new User("Test", "User", "test2@test.com", "password");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userService.getUsers();

        assertEquals(2, result.size());
    }

    @Test
    void testGetUserById() {
        String id = "1";
        User user = new User("Test", "User", "test@test.com", "password");
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(id);

        assertTrue(result.isPresent());
        assertEquals(user.getId(), result.get().getId());
    }

    @Test
    void testCreateUser() {
        User user = new User("Test", "User", "test@test.com", "password");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser(user);

        assertEquals(user.getEmail(), result.getEmail());
    }

    @Test
    void testUpdateUser() {
        String id = "1";
        User existingUser = new User("Existing", "User", "existing@test.com", "password");
        User updatedUser = new User("Updated", "User", "updated@test.com", "password");
        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        Optional<User> result = userService.updateUser(id, updatedUser);

        assertTrue(result.isPresent());
        assertEquals(updatedUser.getEmail(), result.get().getEmail());
    }

    @Test
    void testDeleteUser() {
        String id = "1";
        when(userRepository.existsById(id)).thenReturn(true);

        boolean result = userService.deleteUser(id);

        assertTrue(result);
    }

    @Test
    void testDeleteUserNotFound() {
        String id = "1";
        when(userRepository.existsById(id)).thenReturn(false);

        boolean result = userService.deleteUser(id);

        assertFalse(result);
    }
}
