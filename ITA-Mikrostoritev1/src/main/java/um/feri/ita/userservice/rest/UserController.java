package um.feri.ita.userservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import um.feri.ita.userservice.dao.UserRepository;
import um.feri.ita.userservice.vao.User;

import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger log = Logger.getLogger(UserController.class.toString());
    @Autowired
    public UserController(UserRepository dao) {
        this.dao = dao;
    }

    private UserRepository dao;

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<um.feri.ita.userservice.dto.User> registerUser(@RequestBody um.feri.ita.userservice.dto.User user) {
        um.feri.ita.userservice.vao.User newUser = new User(user);
        dao.save(newUser);
        return ResponseEntity.ok(newUser.toDto());
    }
}
