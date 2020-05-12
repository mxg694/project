package com.luban.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 zuul  过滤器



 */

@Component
public class LogFilter extends ZuulFilter {


    /**
     *  过滤器类型： PRE，ROUTING  POST  ERROR
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器 执行顺序   越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {

        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = ctx.get(FilterConstants.REQUEST_URI_KEY).toString();
        System.out.println(request.getRemoteAddr()+"访问了"+request.getRequestURI()+"路由后的地址:"+s);
        return null;
    }
}
