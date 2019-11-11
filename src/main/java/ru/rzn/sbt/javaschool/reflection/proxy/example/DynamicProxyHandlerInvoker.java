package ru.rzn.sbt.javaschool.reflection.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandlerInvoker implements InvocationHandler {

    private Object real;

    public DynamicProxyHandlerInvoker(Object real) {
        this.real = real;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("I am logging from proxy");
        return method.invoke(real, objects);
    }
}
