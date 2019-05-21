package com.beretwood;

import com.beretwood.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        HibernateUtil.getSessionFactory();
    }
}
