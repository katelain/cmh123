package com.iweb.filter;

import org.junit.Test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * sping0620   IntelliJ IDEA
 * loginFilter
 *
 * @param
 * @author minghuachen
 * @date 2023/7/7 13:45
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String failcount = filterConfig.getInitParameter("failcount");
        int locktime = Integer.parseInt(failcount);
        System.out.println(locktime);
        filterConfig.getServletContext().setAttribute("locktime",locktime);







    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取登录状态和用户等级
        boolean isLoggedIn = checkUserLoggedIn(httpRequest);
        int userLevel = getUserLevel(httpRequest);

        // 根据需求进行相应的控制逻辑
        if (isLoggedIn && userLevel >= 5) {
            // 用户已登录且用户等级大于等于5，允许通过
            chain.doFilter(request, response);
        } else {
            // 用户未登录或用户等级不满足要求，禁止访问
            httpResponse.sendRedirect("/login"); // 重定向到登录页
        }
    }
    private boolean checkUserLoggedIn(HttpServletRequest request) {
        // 用户登录状态检查逻辑，返回登录状态
        // 示例：从session中获取登录状态信息
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("isLoggedIn") != null;
    }

    private int getUserLevel(HttpServletRequest request) {
        // 获取用户等级逻辑，返回用户等级
        // 示例：从session中获取用户等级信息
        HttpSession session = request.getSession(false);
        return session != null ? (int) session.getAttribute("userLevel") : 0;
    }




    @Override
    public void destroy() {

    }

@Test
    public void test(){
        Map map=null;
        System.out.println(map.get("cmh"));

    }

}
