package com.blackduck.app;
import java.io.*;
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
        //if (foo(key2) && bar(key1)) { stuff(); }
    }

}



public class ResourceLeak {
    public void processFiles(String... srcs) throws IOException {
        // Neither this method nor processStream closes
        // the FileInputStream
        for(String src : srcs) {
            processStream(new FileInputStream(src)); // RESOURCE_LEAK defect
        }
    }

    OutputStream dst;
    private void processStream(InputStream src) throws IOException {
        int b;
        while ((b = src.read()) >= 0) {
            dst.write(b);
        }
    }
}
