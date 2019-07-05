package com.qf.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class PerssionHandler {

        public boolean hasPerssion(HttpServletRequest request, Authentication authentication){

            AntPathMatcher antPathMatcher = new AntPathMatcher();

            Object principal = authentication.getPrincipal();

            String requestURI = request.getRequestURI();

            if(principal instanceof UserDetails){

                UserDetails userDetails = (UserDetails) principal;
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

                for (GrantedAuthority authority : authorities) {
                    if(antPathMatcher.match(requestURI, authority.getAuthority())){
                        return true;
                    }
                }
            }

            return false;
        }
}
