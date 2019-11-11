package ru.rzn.sbt.javaschool.reflection.proxy.example;

public class BusinessImpl implements Business {
    public String doSomething() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am doing something for business";
    }
}
