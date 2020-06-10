package com.atguigu.springcloud.lb.impl;

import com.atguigu.springcloud.lb.LoadBalancerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancerInterface {
    private final Logger logger = LoggerFactory.getLogger(MyLB.class);

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private final int getAndIncrement() {
        int current; //表示在初始化该值的那一刻时，工作内存中对应主物理内存中的值的副本
        int next;   //表示是第几次请求

        do {    //整个do语句中的操作是原子性的
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        logger.info("第" + next + "次访问！");
        return next;
    }
}