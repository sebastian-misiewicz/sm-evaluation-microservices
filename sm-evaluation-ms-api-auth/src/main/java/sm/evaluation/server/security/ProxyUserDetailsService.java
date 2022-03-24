package sm.evaluation.server.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import sm.evaluation.server.security.model.User;

public class ProxyUserDetailsService
        implements UserDetailsService {

    private final HttpServletRequest request;

    public ProxyUserDetailsService(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
                    = "http://localhost:8082/api/v1/security";
            ResponseEntity<User> response
                    = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, new HttpEntity<>(createHeaders()), User.class);
            return new ProxyUserPrincipal(response.getBody());
        } catch (Exception ex) {
            throw new UsernameNotFoundException("Correct authorized user has not been found", ex);
        }
    }

    HttpHeaders createHeaders() {
        return new HttpHeaders() {{
            set("Authorization", request.getHeader("authorization"));
        }};
    }

}
