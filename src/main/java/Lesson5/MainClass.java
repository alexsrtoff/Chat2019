package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static int COUNT = 3;


    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        AtomicInteger ai = new AtomicInteger(0);
        Semaphore smp = new Semaphore(CARS_COUNT/2);
        CountDownLatch cdl  = new CountDownLatch(CARS_COUNT*COUNT);
        CountDownLatch cdl1 = new CountDownLatch(CARS_COUNT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60, cdl, ai), new Tunnel(cdl, smp), new Road(40, cdl, ai));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl1);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdl1.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    CyclicBarrier cb;
    CountDownLatch cdl1;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.cb = cb;
        this.cdl1 = cdl;

        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl1.countDown();

            cb.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);

        }
    }
}
abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
class Road extends Stage {
    CountDownLatch cdl;
    AtomicInteger ai;
    public Road(int length, CountDownLatch cdl, AtomicInteger ai) {
        this.ai = ai;
        this.cdl = cdl;
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }


    public Road(int length, CountDownLatch cdl) {
        this.cdl = cdl;
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            cdl.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(ai.incrementAndGet() == MainClass.CARS_COUNT + 1){
            System.out.println(c.getName() + " WIN!");
        }

    }
}
class Tunnel extends Stage {
    CountDownLatch cdl;
    Semaphore smp;
    public Tunnel(CountDownLatch cdl, Semaphore smp) {
        this.smp = smp;
        this.cdl = cdl;
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {

                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();

                cdl.countDown();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}

