package ru.rzn.sbt.javaschool.reflection.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return "I am proxy";
    }
}
