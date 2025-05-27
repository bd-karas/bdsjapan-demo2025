package com.blackduck.app;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Black World!");
    }

}

class TestCopyPasteError {
    Boolean foo(int k) { return true; }
    Boolean bar(int k) { return true; }

    void stuff() { }

    static int key1 = 3, key2 = 5;

    void bar() {
        if (foo(key1) && bar(key1)) { stuff(); }
        // A COPY_PASTE_ERROR defect occurs here.
        if (foo(key2) && bar(key1)) { stuff(); }
    }

}
