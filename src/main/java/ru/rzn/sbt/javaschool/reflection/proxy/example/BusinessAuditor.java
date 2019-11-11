package ru.rzn.sbt.javaschool.reflection.proxy.example;

public class BusinessAuditor implements Business, Audit {
    public String auditSomething(String event) {
        try {
            Thread.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am BusinessAuditor, who audits " + event;
    }

    public String doSomething() {
        try {
            Thread.sleep(89);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "A am doing business";
    }
}
