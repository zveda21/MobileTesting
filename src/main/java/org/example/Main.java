package org.example;

import org.example.factory.AppiumDriverFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("device queue ==> " + AppiumDriverFactory.deviceQueue);
    }
}