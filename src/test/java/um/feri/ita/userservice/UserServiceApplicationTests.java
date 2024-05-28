package um.feri.ita.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.data.mongodb.uri=mongodb://admin:admin@localhost:27018/?authSource=admin&retryWrites=true&w=majority&appName=ita")
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
