package ru.rzn.sbt.javaschool.reflection.proxy.example;

public class NewBusinessImpl implements Business {
    public String doSomething() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I am a new implementation";
    }
}
