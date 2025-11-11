package com.xiaolin.filter;

import com.xiaolin.utils.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author lzh
 * @description: 请求时效Filter
 * @date 2025/11/11 8:08
 */
@Slf4j
//@Component
// 配置过滤器要拦截的请求路径
//  /*          表示拦截浏览器的所有请求
//  /login      只有访问 /login 路径时，才会被拦截
//  /emp/*      访问/emp下的所有资源，都会被拦截
//@WebFilter(urlPatterns = "/*")
public class RequestTimeFilter implements Filter {

    private static final String LOGIN_PATH = "login";
    private static final String TOKEN = "token";

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //1. 获取请求url。
        String url = request.getRequestURL().toString();

        //2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if (url.contains(LOGIN_PATH)) {
            chain.doFilter(request, response);
            return;
        }

        //3. 获取请求头中的令牌（token）。
        String token = request.getHeader(TOKEN);

        //4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if (StringUtils.isEmpty(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //5. 解析token，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //6. 令牌合法, 放行
        chain.doFilter(request, response);
    }
}

