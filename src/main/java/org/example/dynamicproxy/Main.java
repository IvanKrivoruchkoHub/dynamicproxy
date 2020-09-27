package org.example.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Ivan", 21, "Kiev", "Ukraine");
        ClassLoader manClassLoader = man.getClass().getClassLoader();
        Class[] interfaces = man.getClass().getInterfaces();
        Person proxyMan = (Person) Proxy.newProxyInstance(manClassLoader,
            interfaces, new PersonInvocationHandler(man));
        proxyMan.introduce();
    }
}
