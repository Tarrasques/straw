package com.tarrasques.straw.gateway.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        String loginPageUrl = "/login.html";
        String loginUrl = "/login";
        String[] url = {
                "/",
                "/favicon.ico",
                "/browser_components/**",
                "/css/**",
                "/js/**",
                "/img/**",
                "/index.html",
                "/register.html",
                "/api-user/v1/user/reg",
                "/api-question/v1/tags",
                loginPageUrl,
                loginUrl
        };
        //所有请求都需要验证
        http.authorizeRequests().antMatchers(url).permitAll().anyRequest().authenticated();
        //使用表单验证
        http.formLogin().loginPage(loginPageUrl).loginProcessingUrl(loginUrl);
        //关闭跨域
        http.csrf().disable();
    }
}
