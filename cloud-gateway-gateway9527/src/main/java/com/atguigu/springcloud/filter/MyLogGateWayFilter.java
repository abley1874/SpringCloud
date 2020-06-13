package com.atguigu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("come in MyLogGatewayFilter"+ new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");  //获取请求参数 username的值
        if (username==null){
            System.out.println("用户名为null，非法用户！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);  //将数据传入下一个过滤链处理
    }

    @Override   //定义的过滤器等级，0是最高级别
    public int getOrder() {
        return 0;
    }
}
