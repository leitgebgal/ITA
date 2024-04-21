package um.feri.ita.bookservice;

import com.github.javafaker.Faker;
import um.feri.ita.bookservice.dao.BookRepository;
import um.feri.ita.bookservice.vao.Book;

import java.util.logging.Logger;

public class BookRestServiceInit {
    private static final Logger log = Logger.getLogger(BookRestServiceInit.class.toString());

    void populateTestDataIfEmpty(BookRepository daoBooks) {
        if(daoBooks.count() > 0) {
            log.info("populateTestData - skipped.");
            return;
        }
        log.info("populateTestData initiated.");

        Faker faker = new Faker();

        for (int i = 0; i < 50; i++) {
            Book book = new Book();
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setPublisher(faker.book().publisher());
            book.setPublicationYear(faker.number().numberBetween(1900, 2021));

            daoBooks.save(book);
        }
    }
}
