package sm.evaluation.server.restcontroller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sm.evaluation.server.model.User;
import sm.evaluation.server.security.MsUserPrincipal;

@RestController
@RequestMapping(value = "/api/v1/security")
public class SecurityController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public ResponseEntity<User> get(@RequestHeader Map<String, String> headers) {

        headers.forEach((key, value) -> {
            logger.info(String.format("Header '%s' = %s", key, value));
        });

        Authentication userPrincipal = (Authentication) request.getUserPrincipal();
        MsUserPrincipal msUserPrincipal = (MsUserPrincipal) userPrincipal.getPrincipal();

        return ResponseEntity.ok(msUserPrincipal.getUser());
    }

}
