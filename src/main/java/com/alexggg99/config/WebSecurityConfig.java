package com.alexggg99.config;

/**
 * Created by alexggg99 on 25.01.16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/css/**", "/webjars/**", "/js/**").permitAll();

//        http.authorizeRequests()
//                .antMatchers("/staff/**").hasRole("ADMIN");


        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", false)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .and()
                .rememberMe();

        // Custom Token based authentication based on the header previously given to the client
                 http.addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService),
                         UsernamePasswordAuthenticationFilter.class);

//        http.authorizeRequests().antMatchers("/**").permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
    }



}