package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static volatile boolean keepRunning = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Press enter to stop");

        Thread t = new Thread(() -> {
            StringBuilder builder = new StringBuilder();

            while (keepRunning) {
                builder.append("*");
                String firstLine = builder.toString();
                builder.append("**");
                String secondLine = builder.toString();
                builder.setLength(0);
                builder.append(firstLine);

                System.out.println(firstLine);
                System.out.println(secondLine);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //thread start
        t.start();

        //loop stop
        System.in.read();
        keepRunning = false;
        t.join();
    }
}