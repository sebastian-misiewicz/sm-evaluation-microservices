package sm.evaluation.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import sm.evaluation.server.model.User;
import sm.evaluation.server.repository.UserRepository;

@Component
public class MsUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new MsUserPrincipal(user);
    }
}
