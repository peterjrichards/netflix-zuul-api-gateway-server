package net.thefuturetoday.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre"; //intercept all the request before execution
    }

    @Override
    public int filterOrder() {
        return 1; //setting filter order to 1
    }

    @Override
    public boolean shouldFilter() {
        return true; //executing filter for every request
    }

    @Override
    public Object run() throws ZuulException {
        //getting the current HTTP request that is to be handle
        HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
        //printing the detail of the request
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
    }
}
