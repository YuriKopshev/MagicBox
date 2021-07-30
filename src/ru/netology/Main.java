package ru.netology;

import com.sun.security.jgss.GSSUtil;

public class Main {
    public static volatile boolean button;
    private final int pause = 2000;
    Runnable player = new Runnable() {
        @Override
        public void run() {
            System.out.println("Пользватель включил кнопку!");
            button = false;
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable toy = () -> System.out.println("Игрушка отключила кнопку!");


    public void game() {
        int iterationCount = 5;
        for (int i = 0; i < iterationCount; i++) {
            new Thread(player).start();
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!button) {
               new Thread(toy).start();
                button = true;
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Игрушка: хватит меня мучить и нажимать эту кнопку!!!");


    }

    public static void main(String[] args) {
        new Main().game();

    }
}

