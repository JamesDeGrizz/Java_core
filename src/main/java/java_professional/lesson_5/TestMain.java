package java_professional.lesson_5;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMain {
    public static final int CARS_COUNT = 4;

    private static final CountDownLatch cdlReady = new CountDownLatch(CARS_COUNT + 1);
    private static final CountDownLatch cdlFinished = new CountDownLatch(CARS_COUNT);
    private static final Semaphore smpTunnel = new Semaphore(CARS_COUNT / 2);
    private static final Lock winner = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(smpTunnel), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdlReady, winner, cdlFinished);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        while (cdlReady.getCount() != 1) { }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdlReady.countDown();

        try {
            cdlFinished.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
