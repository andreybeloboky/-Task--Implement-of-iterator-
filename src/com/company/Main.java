package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList1 ex = new ArrayList1();
        ex.add("One");
        ex.add("Two");
        ex.add("Three");
        ex.add("Four");
        System.out.println(ex.size());
        Iterator<String> itr = ex.iterator();
        while (itr.hasNext()) {
            String value = itr.next();
            if (value == "Two") {
                itr.remove();
            }
        }
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
