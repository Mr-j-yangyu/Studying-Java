package com.jwx.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: zuul过滤器类
 * <p>
 * PackageName:com.jwx.springcloud.zuul.filter
 * FileName: AccessFilter.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/26
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 返回指定类型过滤器
     *   pre(路由前)：可以利用“Pre”过滤器实现用户鉴权，记录请求日志等
     *   routing(路由时)：可以利用“Routing”过滤器实现动态路由、灰度发布、A/B测试、负载限流等
     *   post（路由后）：可以利用"Post"过滤器收集统计信息和指标，将微服务的相应写入Http响应并返回给服务消费者
     *   error（路由过程发送错误时）：可以利用Error过滤器记录错误日志，并对错误进行二次处理等
     *
     * @return java.lang.String
     * @author jiwenxiang
     * @date 2018/7/26
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序，数值越小优先级越高
     *
     * @return java.lang.String
     * @author jiwenxiang
     * @date 2018/7/26
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * 返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围
     * @return java.lang.String
     * @author jiwenxiang
     * @date 2018/7/26
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return java.lang.String
     * @author jiwenxiang
     * @date 2018/7/26
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request   to %s", request.getMethod(), request.getRequestURL().toString()));
        String accessUser = request.getParameter("user");
        System.out.println(accessUser+"==--");
        if(!accessUser.equals("jwx")) {
            log.warn("access user is wrong");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("Unauthorized");
            return null;
        }
        log.info("access user ok");
        return null;
    }
}