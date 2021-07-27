package ru.netology;

public class Main {


    public static void main(String[] args) {
        int iterationCount = 15000;
        BoxAction action = new BoxAction();
        Thread thread1 = new Thread(null, action::on, "Пользователь");
        Thread thread2 = new Thread(null, action::off, "Игрушка");

        try {
            thread1.start();
            thread2.join();
            thread2.start();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        try {
            Thread.sleep(iterationCount);
            thread1.interrupt();
            if (thread1.isInterrupted()) {
                thread2.interrupt();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

