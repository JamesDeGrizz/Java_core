package java_professional.lesson_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdlReady;
    private CountDownLatch cdlFinished;
    private Lock winner;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdlReady, Lock winner, CountDownLatch cdlFinished) {
        this.race = race;
        this.speed = speed;
        this.cdlReady = cdlReady;
        this.cdlFinished = cdlFinished;
        this.winner = winner;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlReady.countDown();
            cdlReady.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (winner.tryLock()) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Я, " + name + ", победил!!!");
        }

        cdlFinished.countDown();
    }

}
