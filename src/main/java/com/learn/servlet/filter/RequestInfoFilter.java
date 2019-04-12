package com.learn.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String method = req.getMethod();
        String remoteAddr = req.getRemoteAddr();
        String querySrting = req.getProtocol();
        String prptocol = req.getProtocol();
        System.out.println(">> RequestInfoFilter: method:='"+method+"', remoteAddr='"+remoteAddr+"', querySrting='"+querySrting+"', prptocol='"+prptocol);
        System.out.println();

        chain.doFilter(req, resp);
    }
}