package com.qf.shop_back;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.IBackUserService;
import com.qf.utils.PerssionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.header.Header;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Reference
    IBackUserService backUserService;

//    @Reference
//    PerssionHandler perssionHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                    .loginPage("/toLogin")
                    .loginProcessingUrl("/loginCheck")
                    .failureUrl("/toLogin?error=1")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests()
                    .mvcMatchers("/resources/**").permitAll()
                    .mvcMatchers("/").authenticated()
                    .anyRequest().access("@perssionHandler.hasPerssion(request, authentication)")
                    //.anyRequest().authenticated()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(backUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
