package com.xiaolin.handler;

import com.xiaolin.utils.CurrentHolderUtil;
import com.xiaolin.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lzh
 * @description: 拦截器
 * @date 2025/11/11 11:09
 */
@Slf4j
@Component
public class RequestInterceptor implements HandlerInterceptor {

    //private static final String LOGIN_PATH = "login";
    private static final String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // WebConfig 配置了 不拦截 login
        //1. 获取url
        //String req = request.getRequestURL().toString();
        //
        //2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        //if (req.contains(LOGIN_PATH)) {
        //    直接放行
        //    return true;
        //}

        //3. 获取请求头中的令牌（token）。
        String token = request.getHeader(TOKEN);

        if (StringUtils.isEmpty(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //4. 解析token
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String name = (String) claims.get("name");
            CurrentHolderUtil.setCurrentUser(name);
        } catch (Exception e) {
            log.error("jwt解析失败：{}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 清空当前线程绑定的id
        CurrentHolderUtil.remove();
    }
}
