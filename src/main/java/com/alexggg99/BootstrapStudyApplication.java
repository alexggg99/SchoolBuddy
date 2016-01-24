package com.alexggg99;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BootstrapStudyApplication extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cms_app/login").setViewName("login");
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(BootstrapStudyApplication.class).run(args);
    }

    @Bean
    public ApplicationSecurity applicationSecurity() {
        return new ApplicationSecurity();
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable();
            http
                    .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated();
//            http
//                    .authorizeRequests()
//                    .antMatchers("/**", "/webjars/**", "/js/**",
//                            "/photo_gallery_app/**", "/app_sales/**", "/css/**", "/img/**",
//                            "/social_net_app/**", "/app_resume/**", "/agency_app/**",
//                            "/photo_gallery_app/**", "/app_sales/**", "/css/**", "/img/**",
//                            "/cms_app/**", "/web_hosting_app/**").permitAll().anyRequest().permitAll()
////                    .fullyAuthenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/#/cms_app/login")
//                    .failureUrl("/#/cms_app/login?error")
//                    .permitAll()
//                    .and()
//                    .logout()
//                    .logoutSuccessUrl("/cms_app/login")
//                    .permitAll();
////                    .and()
////                    .httpBasic();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("123").roles("USER");
        }

    }

}
