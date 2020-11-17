package com.miyano.enterprisecloud.interceptor;

import com.miyano.enterprisecloud.service.UserService;
import com.miyano.enterprisecloud.util.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器
 *
 * @author Miyano
 * @since 2020/11/12 9:59
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    JedisPool jedisPool;

    @Value("${redis.lifecycle}")
    private Integer validTime;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println ("拦截器生效");
        return isValidToken (request);
    }


    /**
     * 判断 token 是否合法
     *
     * @param request
     * @return
     */
    public boolean isValidToken (HttpServletRequest request) {

        Jedis jedis = jedisPool.getResource ();
        String token = request.getHeader ("token");

        if (token == null) {
            return false;
        }

        if (jedis.ttl (token) >= -1) {
            jedis.expire (token, validTime);
        }

        return jedis.ttl (token) >= -1;
    }


    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
                            ModelAndView modelAndView) throws Exception {
        System.out.println ("拦截方法");
    }


    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler,
                                 Exception ex) throws Exception {
        System.out.println ("拦截结束");
    }
}