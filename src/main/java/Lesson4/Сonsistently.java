package Lesson4;

public class Сonsistently {
    private String letter = "A";
    private Object obj = new Object();


    private void printA(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (!letter.equals("A")) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                letter = "B";
                obj.notify();
            }
        }
    }


    private void printB(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (!letter.equals("B")) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                letter = "C";
                obj.notify();
            }
        }
    }

    private void printC(){
        synchronized (obj){
            for (int i = 0; i < 5; i++) {
                while (!letter.equals("C")) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                letter = "A";
                obj.notifyAll();
            }
        }
    }

    private synchronized void printABC(String s){
        for (int i = 0; i < 5; i++) {
            while (!s.equals(letter)){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(s);
            if (s.equals("A")){
                letter = "B";
            }else if(s.equals("B")) {
                letter = "C";
            }else letter = "A";
            notifyAll();
        }
    }


    public static void main(String[] args) {
        Сonsistently c = new Сonsistently();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printABC("A");
//                    c.printA();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printABC("B");
//                    c.printB();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printABC("C");
//                c.printC();
            }
        });


        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
