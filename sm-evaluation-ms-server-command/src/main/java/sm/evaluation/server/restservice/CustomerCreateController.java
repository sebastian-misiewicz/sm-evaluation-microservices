package sm.evaluation.server.restservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sm.evaluation.server.command.CreateCustomerCommand;
import sm.evaluation.server.model.Customer;
import sm.evaluation.server.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerCreateController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerCreateController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCustomerCommand createCustomerCommand) {

        customerRepository.insert(new Customer(createCustomerCommand));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable(value = "email") String email) {
        customerRepository.findById(email).ifPresent(customer -> customerRepository.delete(customer));
        return ResponseEntity.ok().build();
    }

}
