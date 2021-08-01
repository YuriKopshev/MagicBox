package ru.netology;

import com.sun.security.jgss.GSSUtil;

public class Main {
    public static volatile boolean button;
    private static final int PAUSE = 2000;
    private static final int ITERATIONS = 5;
    Runnable player = new Runnable() {
        @Override
        public void run() {
            System.out.println("Пользватель включил кнопку!");
            button = false;
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable toy = () -> System.out.println("Игрушка отключила кнопку!");

    public void game() {
        new Thread(player).start();
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!button) {
            new Thread(toy).start();
            button = true;
        }
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < ITERATIONS; i++) {
            new Main().game();
        }
        System.out.println("Игрушка: хватит меня мучить и нажимать эту кнопку!!!");
    }
}

