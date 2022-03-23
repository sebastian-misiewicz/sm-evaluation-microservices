package sm.evaluation.server.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;

public abstract class AbstractProxySecurityConfig {

    @Bean
    public ProxyUserDetailsService userDetailsService(HttpServletRequest request) {
        return new ProxyUserDetailsService(request);
    }

    @Bean
    public ProxyJWTTokenRequestFilter proxyJWTTokenRequestFilter(ProxyUserDetailsService proxyUserDetailsService) {
        return new ProxyJWTTokenRequestFilter(proxyUserDetailsService);
    }

    @Bean
    public JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JWTAuthenticationEntryPoint();
    }


}
