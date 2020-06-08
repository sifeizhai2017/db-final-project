package com.shnu.work.interceptor;

import com.shnu.work.util.NewRedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 *
 * @author Shinomiya Kaguya
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        NewRedisUtils newRedisUtils = NewRedisUtils.getRedisUtil();
        HttpSession session = request.getSession();
        String jSessionId = session.getId();
        LOGGER.info("jsessionid:{}", jSessionId);
        String userInfo;
        try {
            userInfo = newRedisUtils.get(0, jSessionId);
            LOGGER.info("userInfo:{}", userInfo);
        } catch (Exception e) {
            return true;
        }
        LOGGER.info("userInfo:{}", userInfo);

        return userInfo != null;
    }
}
