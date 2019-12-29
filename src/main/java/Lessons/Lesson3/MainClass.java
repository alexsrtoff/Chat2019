package Lessons.Lesson3;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class MainClass {
    public static void main(String[] args) throws IOException {

//        /*Задание 1*/
//        File file = new File("Files/task1.txt");
//        try (FileInputStream in = new FileInputStream(file)) {
//            byte[] arr = new byte[512];
//            int x;
//            while ((x = in.read(arr)) != -1) {
//                System.out.print(new String(arr, 0, x, "UTF-8"));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        /*Задание 2*/
//        ArrayList<InputStream> al = new ArrayList<>();
//        al.add(new FileInputStream("Files/Task_2/1.txt"));
//        al.add(new FileInputStream("Files/Task_2/2.txt"));
//        al.add(new FileInputStream("Files/Task_2/3.txt"));
//        al.add(new FileInputStream("Files/Task_2/4.txt"));
//        al.add(new FileInputStream("Files/Task_2/5.txt"));
//
//        Enumeration<InputStream> e = Collections.enumeration(al);
//        SequenceInputStream in  = new SequenceInputStream(e);
//        byte[] data = new byte[200];
//
//        int x;
//        while ((x = in.read(data)) != -1) {
//
//            System.out.print(new String(data, 0, x, "UTF-8"));
//        }
//        System.out.println();
//        in.close();
//

    /* Задание 3*/



        try (RandomAccessFile raf = new RandomAccessFile("Files/task3_2.txt", "r")) {
            raf.seek(0);
            char text1 = (char)raf.read();
            System.out.println(text1);
//            byte[] data1 = new byte[4];
////            raf.read(data1, 0, data1.length);
////            String text = new String(data1, 0, data1.length, "UTF-8");
////            System.out.println(text);
//
////            raf.seek(0);
////            int of = 0;
//            char[] c = new char[1800];
//                byte[] v = new byte[1800];
//            for (int i = 0; i < 1800 ; i++) {
////                byte[] v = new byte[1800];
//                raf.seek(i);
////                char text1 = (char)raf.read();
//                c[i] = (char)raf.read();
////                v[i] = (byte) raf.read();
//                System.out.print(new String(v, 0, v.length, "UTF-8"));
//            }
//            System.out.print(new String(v, 0, 100, "UTF-8"));


//            System.out.println(new String(data1, 0, 1020, "UTF-8"));
        }


    }


}
