package ru.rzn.sbt.javaschool.reflection.proxy.example;

public class AuditImpl implements Audit{
    public String auditSomething(String event) {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am auditor of " + event;
    }
}
