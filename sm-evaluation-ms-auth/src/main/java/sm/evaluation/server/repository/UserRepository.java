package sm.evaluation.server.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import sm.evaluation.server.security.model.User;


public interface UserRepository
        extends MongoRepository<User, String> {

    @Query("{username: ?0}")
    Optional<User> getUserByUsername(String username);

}
