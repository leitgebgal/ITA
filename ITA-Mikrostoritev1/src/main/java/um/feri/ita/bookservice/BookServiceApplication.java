package um.feri.ita.bookservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import um.feri.ita.bookservice.dao.BookRepository;

import java.util.logging.Logger;

@SpringBootApplication
public class BookServiceApplication {
    private static final Logger log = Logger.getLogger(BookServiceApplication.class.toString());
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository daoBook) {
        return args -> {
            log.info("Ready, Set, Go!");
            new BookRestServiceInit().populateTestDataIfEmpty(daoBook);
        };
    }
}
