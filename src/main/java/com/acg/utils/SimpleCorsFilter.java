package com.acg.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * SimpleCORSFilter
 * @date 2019-04-28 15:40
 * @version V1.0.0
 **/
@Component
public  class SimpleCorsFilter implements Filter {

    private static final String METHOD_OPTIONS = "OPTIONS";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin",  httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authentication,Origin,X-Requested-With,Content-Type,Accept,x-token,token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("XDomainRequestAllowed","1");

        String method = httpServletRequest.getMethod();

        if (METHOD_OPTIONS.equals(method)){
            filterChain.doFilter(httpServletRequest, servletResponse);
        } if (httpServletRequest.getRequestURI().contains("login")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}