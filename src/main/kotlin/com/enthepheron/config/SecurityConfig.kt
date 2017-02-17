package com.enthepheron.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        // Any request is required for authentication.
        http!!.authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated()


        // Authentication configuration.
        http.formLogin()
                .loginProcessingUrl("/login_process")
                .loginPage("/login")
                .failureUrl("/login_error")
                .defaultSuccessUrl("/main", true)
                .usernameParameter("user_id")
                .passwordParameter("pass_word")

        // Logout configuration.
        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN")
    }
}