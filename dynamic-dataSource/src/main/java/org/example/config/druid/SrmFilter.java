package org.example.config.druid;

import org.slf4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SrmFilter implements Filter{
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(SrmFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器执行");
        String token = servletRequest.getParameter("token");
        if (isIgnore(servletRequest)) {
            //放开执行
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //校验token
//        if (!"123456".equals(token)) {
//            logger.info("请求被拦截");
//            PrintWriter writer = null;
//            servletResponse.setCharacterEncoding("UTF-8");
//            servletResponse.setContentType("text/html; charset=utf-8");
//            try {
//                writer = servletResponse.getWriter();
//                String error = "token信息有误";
//                writer.print(error);
//            } catch (IOException e) {
//                logger.error("response error", e);
//            } finally {
//                if (writer != null)
//                    writer.close();
//            }
//        } else {
//            logger.info("请求放行");
//            //放开执行
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
    }

    private boolean isIgnore(ServletRequest servletRequest) {
        boolean isIgnore = false;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath();      //请求页面或其他地址
        logger.info("url:" + url);
        if (url.contains("druid")) {
            isIgnore = true;
            logger.info("不拦截的url:" + url);
        }
        if (url.contains("static")) {
            isIgnore = true;
            logger.info("不拦截的url:" + url);
        }
        return isIgnore;
    }

    public void destroy() {
        logger.info("过滤器销毁");
    }

}
