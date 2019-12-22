package com.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//@WebFilter(filterName = "LoginFilter",urlPatterns = "/**")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest)req;
        HttpServletResponse response= (HttpServletResponse)resp;

        String uri = request.getRequestURI();
        System.out.println(uri+"------------");
        System.out.println(request.getServletPath()+"--------");
        if(uri.contains("/plugins") ||uri.contains("/css")||uri.contains("/layui")||uri.contains("/register")||uri.contains("/msg")||uri.contains("/html")){
            System.out.println(uri);
            chain.doFilter(request,response);
            return;
        }
        if (!uri.contains("/login")){
            HttpSession session=request.getSession();
            List<String > role = (List<String>) session.getAttribute("ROLE");
            if (role != null) {
                System.out.println(role);
                chain.doFilter(request,response);
            }else {
                System.out.println("2222");
                request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
            }
        }else {
            chain.doFilter(req,resp);

        }


    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("tttttttttttttttttttt");
    }
    private boolean isLogin(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        String account = "";
        String pwd = "";

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("account")) {
                    account = cookie.getValue();
                } else if (cookie.getName().equals("pwd")) {
                    pwd = cookie.getValue();

            }   }
        }
        if (account.equals("") || pwd.equals("")) {
            return false;

        } else if (account.equals("yzq") && pwd.equals("123")) {
            return true;
        }
        return false;
    }



}
