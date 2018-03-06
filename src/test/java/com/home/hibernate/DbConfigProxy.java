package com.home.hibernate;

import net.ttddyy.dsproxy.asserts.ProxyTestDataSource;
import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@TestConfiguration
public class DbConfigProxy {

    @Component
    public class ProxyTestDataSourceBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
            if(o instanceof DataSource){
                ProxyDataSource proxyDataSource = ProxyDataSourceBuilder.create((DataSource) o)
                        .logQueryBySlf4j(SLF4JLogLevel.INFO)
                        .countQuery()
                        .logSlowQueryBySlf4j(10, TimeUnit.MINUTES)
                        .build();

                return new ProxyTestDataSource(proxyDataSource);
            }
            return o;
        }

        @Override
        public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
            return o;
        }
    }
}