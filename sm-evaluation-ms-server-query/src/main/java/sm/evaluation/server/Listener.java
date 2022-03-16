package sm.evaluation.server;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import sm.evaluation.server.event.CustomerCreated;
import sm.evaluation.server.event.CustomerDeleted;
import sm.evaluation.server.event.Topics;
import sm.evaluation.server.model.Customer;
import sm.evaluation.server.repository.CustomerRepository;

@Component
@KafkaListener(topics = Topics.EVENT_TOPIC)
public class Listener {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public Listener(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @KafkaHandler
    public void listener(@Payload CustomerCreated customerCreated, ConsumerRecord<String, Customer> cr) {
        logEvent(customerCreated);
        customerRepository.insert(new Customer(customerCreated));
    }

    @KafkaHandler
    public void listener(@Payload CustomerDeleted customerDeleted, ConsumerRecord<String, Customer> cr) {
        logEvent(customerDeleted);
        customerRepository.findById(customerDeleted.getId()).ifPresent(customer -> customerRepository.delete(customer));
    }

    private void logEvent(Object event) {
        System.out.println(String.format("Topic [event-topic] Received message with new event %s [%s]", event.getClass().getName(), event));
    }

}
