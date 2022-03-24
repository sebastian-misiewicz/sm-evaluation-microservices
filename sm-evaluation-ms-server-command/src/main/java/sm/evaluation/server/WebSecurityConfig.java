package sm.evaluation.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import sm.evaluation.server.security.JWTAuthenticationEntryPoint;
import sm.evaluation.server.security.ProxyJWTTokenRequestFilter;
import sm.evaluation.server.security.ProxyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter {

    private final ProxyUserDetailsService userDetailsService;

    private final ProxyJWTTokenRequestFilter proxyJWTTokenRequestFilter;

    private final JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public WebSecurityConfig(ProxyUserDetailsService userDetailsService, ProxyJWTTokenRequestFilter proxyJWTTokenRequestFilter, JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.proxyJWTTokenRequestFilter = proxyJWTTokenRequestFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and().authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().csrf().disable();

        http.addFilterBefore(proxyJWTTokenRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public UserDetailsService userDetailsService() {

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
}
