package Lessons.Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader_Task3 {

    static ArrayList<Character> t = new ArrayList<>();
    static int page;
    public static void main(String[] args) {

        try (InputStreamReader in = new InputStreamReader(new FileInputStream("Files/task3.txt"), "UTF-8")) {
            int x;
            long l = System.currentTimeMillis();
            while ((x = in.read()) != -1) {
                t.add((char) (x));
            }
            System.out.println("Время чтения файла");
            System.out.println(System.currentTimeMillis() - l);

            while (true){
                if (page < 0) break;
                askPage();
                long a = System.currentTimeMillis();
                printPage(page);
                System.out.println("Время вывода на печать страницы");
                System.out.println(System.currentTimeMillis() - a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void askPage() {
        System.out.println();
        System.out.println("Введите страницу для чтения");
        Scanner scanner = new Scanner(System.in);
        page = scanner.nextInt();
        if (page * 1800 > t.size()){
            System.out.println("Книга прочтена");
        }
    }

    private static void printPage(int currentPage) {
        if(currentPage > 0) {
            for (int i = 0 + (1800 * (currentPage - 1)); i < 1800 + (1800 * (currentPage - 1)); i++) {
                if (i == t.size()) {
                    System.out.println("Книга окончена");
                    page = -1;
                    break;
                }
                System.out.print(t.get(i));
            }
            System.out.println();
        }else {
            System.out.println("Введите положительное число");
            askPage();
        }


    }
}
