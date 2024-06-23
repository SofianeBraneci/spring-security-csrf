package com.learn.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

public class CsrfLoggingFilter extends OncePerRequestFilter {
    private final Logger logger = Logger.getLogger(CsrfLoggingFilter.class.getName());
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");

        logger.info("CSRF token " + token.getToken());
        filterChain.doFilter(request, response);
    }
}
