package com.iotdeveloper.cloudtools.conf;

import com.iotdeveloper.cloudtools.model.MyPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
                .withUser("lwp").password("lwp").roles("USER")
                .and()
                .withUser("zyp").password("zyp").roles("USER");

    }


    @Override
    public void configure(WebSecurity web) throws  Exception
    {
        web.ignoring().antMatchers("/resources/static/**");

    }
}
