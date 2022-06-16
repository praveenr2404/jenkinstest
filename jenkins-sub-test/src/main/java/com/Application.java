package com;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        String filePath = new File("out/test.txt").getAbsolutePath();
        System.out.println(filePath);
        WriteFile.write(filePath);
        System.out.println("Write Success");
    }
}
