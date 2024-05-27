package um.feri.ita.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import um.feri.ita.userservice.dao.UserRepository;

import java.util.logging.Logger;

@SpringBootApplication
public class UserServiceApplication {
    private static final Logger log = Logger.getLogger(UserServiceApplication.class.toString());
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository daoUser) {
        return args -> {
            log.info("Ready, Set, Go!");
            new UserRestServiceInit().populateTestDataIfEmpty(daoUser);
        };
    }
}
