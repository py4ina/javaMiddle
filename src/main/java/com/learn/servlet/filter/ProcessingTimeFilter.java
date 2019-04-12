package com.learn.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class ProcessingTimeFilter implements Filter {

    public ProcessingTimeFilter() {
        System.out.println(">> ProcessingTimeFilter - NEW");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println(">> ProcessingTimeFilter - init");
        config.getServletContext().log(">> log >>");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        long inTime = System.nanoTime();
        chain.doFilter(req, resp);
        long outTime = System.nanoTime();
        System.out.println(">> ProcessingTimeFilter: dt = " + (outTime - inTime));
        System.out.println();
    }

    @Override
    public void destroy() {
        System.out.println(">> ProcessingTimeFilter - destroy");
    }
}
