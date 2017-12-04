package com.springapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 8:44 AM
 * To change this template use File | Settings | File Templates.
 */
@WebFilter(urlPatterns="/*")
public class CharacterEncodingFilter implements Filter {

    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
//        ServletInputStream servletInputStream = request.getInputStream();
//        byte[] bytes = new byte[1024];
//        servletInputStream.read(bytes);

        //set character encoding using utf-8
        System.out.println("执行过滤操作");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("过滤器初始化");
    }

}