package Lessons.Lesson3;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class MainClass {
    public static void main(String[] args) throws IOException {

        /*Задание 1*/
        File file = new File("Files/task1.txt");
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*Задание 2*/
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("Files/Task_2/1.txt"));
        al.add(new FileInputStream("Files/Task_2/2.txt"));
        al.add(new FileInputStream("Files/Task_2/3.txt"));
        al.add(new FileInputStream("Files/Task_2/4.txt"));
        al.add(new FileInputStream("Files/Task_2/5.txt"));

        Enumeration<InputStream> e = Collections.enumeration(al);
        SequenceInputStream in  = new SequenceInputStream(e);
        byte[] data = new byte[200];

        int x;
        while ((x = in.read(data)) != -1) {

            System.out.print(new String(data, 0, x, "UTF-8"));
        }
        System.out.println();
        in.close();


    /* Задание 3*/

//        try (RandomAccessFile raf = new RandomAccessFile("Files/task3.txt", "r")) {
//            raf.seek(0);
//            byte[] data1 = new byte[1024];
//            raf.read(data1, 0, data.length);
//            String text = new String(data, 0, data.length, "UTF-8");
//            System.out.println(text);
//            raf.seek(0);
//            String str = new String(raf.read(data1))
//            int of = 0;
//
//            System.out.println(new String(data1, 0, 1020, "UTF-8"));
//        }
//

    }


}
