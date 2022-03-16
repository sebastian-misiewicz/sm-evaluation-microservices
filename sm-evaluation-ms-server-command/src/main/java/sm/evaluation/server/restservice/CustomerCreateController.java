package sm.evaluation.server.restservice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sm.evaluation.server.command.CreateCustomerCommand;
import sm.evaluation.server.event.CustomerCreated;
import sm.evaluation.server.event.CustomerDeleted;
import sm.evaluation.server.event.Topics;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerCreateController {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public CustomerCreateController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCustomerCommand createCustomerCommand) {

        // TODO How to set ID in microservices?
        // TODO How to ensure, that two instances are not added?
        CustomerCreated customerCreated = new CustomerCreated(UUID.randomUUID().toString(), createCustomerCommand.getName(), createCustomerCommand.getEmail());

        kafkaTemplate.send(Topics.EVENT_TOPIC, customerCreated);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {

        kafkaTemplate.send(Topics.EVENT_TOPIC, new CustomerDeleted(id));
        return ResponseEntity.ok().build();
    }

}
