package um.feri.ita.userservice;
import um.feri.ita.userservice.dao.UserRepository;
import um.feri.ita.userservice.vao.User;

import java.util.logging.Logger;

public class UserRestServiceInit {
    private static final Logger log = Logger.getLogger(UserRestServiceInit.class.toString());

    void populateTestDataIfEmpty(UserRepository daoUsers) {
        try {
            if (daoUsers.count() > 0) {
                log.info("populateTestUsers - skipped.");
                return;
            }
            log.info("populateTestUsers initiated.");

            User u1 = new User();
            u1.setEmail("gal.leitgeb@gmail.com");
            u1.setFirstName("Gal");
            u1.setLastName("Leitgeb");
            u1.setPassword("P4$$W0rD");
            daoUsers.save(u1);

            log.info("User 1 inserted successfully.");

            User u2 = new User();
            u2.setEmail("john.doe@gmail.com");
            u2.setFirstName("John");
            u2.setLastName("Doe");
            u2.setPassword("test1234");
            daoUsers.save(u2);

            log.info("User 2 inserted successfully.");
        } catch (Exception e) {
            log.severe("Failed to populate users: " + e.getMessage());
        }
    }
}
