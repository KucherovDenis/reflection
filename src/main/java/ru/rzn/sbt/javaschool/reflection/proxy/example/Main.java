package ru.rzn.sbt.javaschool.reflection.proxy.example;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
//        Business proxy = (Business) Proxy.newProxyInstance(
//                Business.class.getClassLoader(),
//                new Class[]{Business.class},
//                new DynamicProxyMonitoring(new NewBusinessImpl())
//
//        );
//
//        System.out.println(proxy.doSomething());
//
//        Audit auditProxy = (Audit) Proxy.newProxyInstance(
//                Audit.class.getClassLoader(),
//                new Class[]{Audit.class},
//                new DynamicProxyMonitoring(new AuditImpl())
//        );
//
//        System.out.println(auditProxy.auditSomething("learning"));


        Object businessAuditorProxy = Proxy.newProxyInstance(
                BusinessAuditor.class.getClassLoader(),
                new Class[]{Audit.class, Business.class},
                new DynamicProxyMonitoring(new BusinessAuditor())
        );

        System.out.println(((Audit) businessAuditorProxy).auditSomething("understanding proxy"));
        System.out.println(((Business) businessAuditorProxy).doSomething());

    }


}
