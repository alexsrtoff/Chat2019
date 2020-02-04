package Lesson4;

public class MFU {

    public synchronized void print(String clientName, String msg){
        System.out.println("Начало печати от клиента " + clientName);
        System.out.println("Напечатано сообщение " + msg);
        System.out.println("Конец печати от клиента " + clientName);
    }

    public void scan(String clientName, String msg){
        System.out.println("Начало сканирования от клиента " + clientName);
        System.out.println("Отсканировано сообщение " + msg);
        System.out.println("Конец сканирования от клиента " + clientName);
    }

    public void copy(String clientName, String msg){
        System.out.println("Сканируем для печати...");
        scan(clientName, msg);
        System.out.println("Печатаем скопированное...");
        print(clientName, msg);
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Bob", "Hello");
                System.out.println();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Bob1", "Hello1");
                System.out.println();

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.copy("Bob2", "Hello2");
                System.out.println();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Bob3", "Hello3");
                System.out.println();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
