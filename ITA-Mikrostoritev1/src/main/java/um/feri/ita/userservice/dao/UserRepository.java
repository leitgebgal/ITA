package um.feri.ita.userservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import um.feri.ita.userservice.vao.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
