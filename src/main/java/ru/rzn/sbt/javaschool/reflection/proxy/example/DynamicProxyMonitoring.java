package ru.rzn.sbt.javaschool.reflection.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyMonitoring implements InvocationHandler {
    private Object real;

    public DynamicProxyMonitoring(Object real) {
        this.real = real;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = method.invoke(real, objects);

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        return result;
    }
}
