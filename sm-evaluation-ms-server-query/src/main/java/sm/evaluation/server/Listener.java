package sm.evaluation.server;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import sm.evaluation.server.event.CustomerCreated;
import sm.evaluation.server.event.CustomerDeleted;
import sm.evaluation.server.event.Topics;
import sm.evaluation.server.model.Customer;
import sm.evaluation.server.repository.CustomerRepository;

@Component
public class Listener {

    @Autowired
    private CustomerRepository customerRepository;

    @KafkaListener(topics = Topics.EVENT_TOPIC)
    public void listener(@Payload CustomerCreated customerCreated, ConsumerRecord<String, Customer> cr) {
        System.out.println(String.format("Topic [event-topic] Received message with new CustomerCreated for id %s with name %s and email %s", customerCreated.getId(), customerCreated.getName(), customerCreated.getEmail()));
        System.out.println(cr.toString());
        customerRepository.insert(new Customer(customerCreated));
    }

    @KafkaListener(topics = Topics.EVENT_TOPIC)
    public void listener(@Payload CustomerDeleted customerDeleted, ConsumerRecord<String, Customer> cr) {
        System.out.println(String.format("Topic [event-topic] Received message with new CustomerDeleted for id %s", customerDeleted.getId()));
        System.out.println(cr.toString());
        customerRepository.findById(customerDeleted.getId()).ifPresent(customer -> customerRepository.delete(customer));

    }


}
