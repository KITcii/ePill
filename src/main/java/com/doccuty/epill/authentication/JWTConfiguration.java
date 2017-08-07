package com.doccuty.epill.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doccuty.epill.user.UserService;

@Configuration
public class JWTConfiguration {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    /*
     * define directories requiring authorization
     */
    
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JWTFilter(authenticationService, userService));
        bean.addUrlPatterns("/*");
        return bean;
    }
}
