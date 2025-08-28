package com.example.springbasicstraining.labs.step7_aop_basics.filter;

import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class TraceIdFilter implements Filter {
    private static final String KEY = "traceId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        MDC.put(KEY, UUID.randomUUID().toString().substring(0, 8));
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove(KEY);
        }
    }
}
