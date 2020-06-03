package com.utcn.security;

import com.utcn.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
public class LoginPageFilter extends OncePerRequestFilter {

    @Autowired
    private SecurityUtil securityUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String contextPath = request.getContextPath();
            String relativeRedirectUrl = securityUtil.getRedirectUrlAfterLoginDependingOnAuthentication(authentication);
            response.sendRedirect(contextPath + relativeRedirectUrl);
        }
        filterChain.doFilter(request, response);
    }
}
