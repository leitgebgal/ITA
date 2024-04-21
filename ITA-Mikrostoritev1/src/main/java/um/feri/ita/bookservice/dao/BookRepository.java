package um.feri.ita.bookservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import um.feri.ita.bookservice.vao.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
