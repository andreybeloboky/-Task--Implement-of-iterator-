package com.company;

public interface List1 extends Iterable<String> {
    void add (String e);
    void remove(int index);
    String get(int index);
    int size();
    void set(int index, String e);
}
