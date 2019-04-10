package com.learn.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestInfoFilter extends BaseFilter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String method = req.getMethod();
        String remoteAddr = req.getRemoteAddr();
        String querySrting = req.getProtocol();
        String prptocol = req.getProtocol();
        System.out.println(">> RequestInfoFilter - doFilter >>");
        System.out.println();

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
