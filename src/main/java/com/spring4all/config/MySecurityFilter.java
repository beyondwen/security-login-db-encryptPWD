package com.spring4all.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

@Component
public class MySecurityFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;

    @Override
    public AuthenticationManager getAuthenticationManager() {
        return super.getAuthenticationManager();
    }

    @PostConstruct
    public void init() {
        super.setAccessDecisionManager(urlAccessDecisionManager);
        super.setAuthenticationManager(getAuthenticationManager());
    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation filterInvocation = new FilterInvocation(request, response, filterChain);
        invoke(filterInvocation);
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        System.out.println("filter..........................");
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }


    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        System.out.println("custom MetadataSource...........................");
        return this.urlFilterInvocationSecurityMetadataSource;
    }
}
