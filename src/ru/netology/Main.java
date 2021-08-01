package ru.netology;

import com.sun.security.jgss.GSSUtil;

public class Main {
    public static volatile boolean button;
    private static final int PAUSE = 2000;
    private static final int ITERATIONS = 5;
    private static final Runnable player = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println("Пользователь включил кнопку!");
                button = false;
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static final Runnable toy = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                System.out.println("Игрушка отключила кнопку!");
                button = true;
                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };


    public static void game() {
        new Thread(player).start();
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!button) {
            new Thread(toy).start();

        }
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main.game();
    }
}

