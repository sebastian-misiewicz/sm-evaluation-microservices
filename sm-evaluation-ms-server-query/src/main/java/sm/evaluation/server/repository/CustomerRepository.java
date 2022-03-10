package sm.evaluation.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sm.evaluation.server.model.Customer;

public interface CustomerRepository
        extends MongoRepository<Customer, String> {
}
