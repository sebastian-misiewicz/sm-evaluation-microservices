package sm.evaluation.server;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import sm.evaluation.server.event.CustomerCreated;
import sm.evaluation.server.event.Topics;
import sm.evaluation.server.model.Customer;

@Component
public class Listener {

    @KafkaListener(topics = Topics.EVENT_TOPIC)
    public void listener(@Payload CustomerCreated customerCreated, ConsumerRecord<String, Customer> cr) {
        System.out.println(String.format("Topic [event-topic] Received message with new customerCreated %s with name %s", customerCreated.getEmail(), customerCreated.getName()));
        System.out.println(cr.toString());
    }

}
