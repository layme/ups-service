package com.ziroom.ups.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.ziroom.ups.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @create 2018-12-15 19:51
 * Description:
 */
@Slf4j
@Aspect
@Configuration
public class LogParamAspect {

    /**
     * 定义切点Pointcut
     */
    @Pointcut("execution(* com.ziroom.ups.controller.*Controller.*(..))")
    public void executeService() {
    }

    /**
     * 拦截请求后打印参数
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 获取请求信息
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = JSON.toJSONString(request.getParameterMap());
        // 生成请求Uid
        String requestUid = Utils.genUUID();
        log.info("{} 请求开始, method: {}, uri: {}, params: {}", requestUid, method, uri, queryString);
        long start = System.currentTimeMillis();
        // 返回值
        Object result = point.proceed();
        log.info("{} 请求结束，耗时: {} ms, 返回值是: {}", requestUid, (System.currentTimeMillis() - start), result);
        return result;
    }
}
