package sm.evaluation.server;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import sm.evaluation.server.repository.UserRepository;
import sm.evaluation.server.security.model.Role;
import sm.evaluation.server.security.model.User;
import sm.evaluation.server.security.model.UserBuilder;

@Component
public class MongoInitializer
        implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;

    public MongoInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (userRepository.getUserByUsername("ian.kowalski").isPresent()) {
            return;
        }

        User user = UserBuilder.anUser()//
                .withUsername("ian.kowalski")//
                .withPassword("$2a$10$.qKCCqwwQFWUTPeciI2yJOVWNhsBjExyiKdsFJrHWujMd0pHaHiUi")//
                .withRoles(new HashSet<>(Arrays.asList(Role.ADMIN, Role.USER)))//
                .build();

        userRepository.insert(user);
    }
}
