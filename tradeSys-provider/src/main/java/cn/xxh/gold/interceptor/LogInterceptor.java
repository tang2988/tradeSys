package cn.xxh.gold.interceptor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 审计日志
 * 
 * @version 2016年8月19日下午2:51:33
 * @author du.dxlove
 */
public class LogInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    
    private static final int A_INT = 100;
    
    private static final ThreadLocal<Long> START_TIME_THREAD_LOCAL =
            new NamedThreadLocal<Long>("ThreadLocal StartTime");
    
    @Value("#{configProperties['auditLogOnoff']}")
    private String auditLogOnoff; // 审计日志开关 0表示关闭 1表示打开 为空或其它都为打开
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
            throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        
        // 1、开始时间
        long beginTime = System.currentTimeMillis();
        START_TIME_THREAD_LOCAL.set(beginTime); // 线程绑定变量（该数据只有当前请求的线程可见）
        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime),
                request.getRequestURI());
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
    
    @SuppressWarnings("unused")
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        
        final String requestRri = request.getRequestURI();
        String uriPrefix = request.getContextPath();
        
        StringBuilder params = new StringBuilder();
        int index = 0;
        for (Object param : request.getParameterMap().keySet()) {
            if (StringUtils.isNotBlank(request.getParameter((String) param))) {
                params.append((index++ == 0 ? "" : "&") + param + "=");
            }
        }
        
        // 得到线程绑定的局部变量（开始时间）
        long beginTime = START_TIME_THREAD_LOCAL.get();
    }
    
}
