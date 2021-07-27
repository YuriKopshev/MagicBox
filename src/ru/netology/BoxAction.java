package ru.netology;

public class BoxAction extends Thread {
    int pauseIteration = 3000;
    int startWaiting = 1000;

    public void on() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(startWaiting);
                System.out.println(Thread.currentThread().getName() + " включил тумблер");
                Thread.sleep(pauseIteration);
            }
        } catch (InterruptedException exception) {
            return;
        }
    }

    public void off() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(pauseIteration);
                System.out.println(Thread.currentThread().getName() + " выключил тумблер");
                Thread.sleep(startWaiting);
            }
        } catch (InterruptedException exception) {
            return;
        }
    }
}
