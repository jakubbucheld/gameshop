package pl.gameshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import pl.gameshop.security.Roles;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    private final DataSource dataSource;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") // tłumienie warningu - bug IntelliJ'a/Springa
    public SecurityConfig(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("SELECT username, password, active FROM users WHERE username = ?")
                    .authoritiesByUsernameQuery("SELECT username, role FROM users_roles WHERE username = ?");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/webjars", "/webjars/**");
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/articles/add", "/articles/add/**").hasRole("AUTHOR")
                .antMatchers("/users", "/users/**").hasRole("ADMIN")
                .antMatchers("/commentaries", "/commentaries/**").authenticated()
                .and()
                .formLogin();
        http
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());

    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler()
    {
        return new CustomAccessDeniedHandler();
    }

}
