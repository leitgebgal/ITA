package um.feri.ita.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.feri.ita.userservice.dao.UserRepository;
import um.feri.ita.userservice.vao.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(String id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if(existingUser.isPresent()) {
            User presentUser = existingUser.get();
            presentUser.setFirstName(updatedUser.getFirstName());
            presentUser.setLastName(updatedUser.getLastName());
            presentUser.setEmail(updatedUser.getEmail());
            presentUser.setPassword(updatedUser.getPassword());

            return Optional.of(userRepository.save(presentUser));
        } else {
            return Optional.empty();
        }
    }
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
