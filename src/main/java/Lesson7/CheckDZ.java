package Lesson7;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;


public class CheckDZ {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/GB study/JavaCore3/Chat/Files/HT7");
        String[] str = file.list();

        for (String o : str) {

            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            Class cl = ClassLoader.getSystemClassLoader().loadClass(mass[0]);
            Method[] methods = cl.getDeclaredMethods();

            System.out.println("File " + mass[0]);
            Method calculateInt = cl.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
            calculateInt.setAccessible(true);
            System.out.println("Test method calculateInt, numbers 1,2,3,4: result " + calculateInt.invoke(new Object(), 1,2,3,4));

            Method calculateFloat = cl.getDeclaredMethod("calculate", float.class, float.class, float.class, float.class);
            calculateFloat.setAccessible(true);
            System.out.println("Test method calculateFloat, numbers 1.1f,2.2f,3.3f,4.4f: result " + calculateFloat.invoke(new Object(), 1.1f,2.2f,3.3f,4.4f));

            Method checkTwoNumbers = cl.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
            checkTwoNumbers.setAccessible(true);
            System.out.println("Test method checkTwoNumbers (12 & 30) " + checkTwoNumbers.invoke(new Object(), 12, 30));

            Method printIsPositive = cl.getDeclaredMethod("printIsPositive", int.class);
            printIsPositive.setAccessible(true);
            System.out.println("Test method printIsPositive positive numer 12");
            printIsPositive.invoke(new Object(), 12);
            System.out.println("Test method printIsPositive negative number -212");
            printIsPositive.invoke(new Object(), -212);

            Method isNegative = cl.getDeclaredMethod("isNegative", int.class);
            isNegative.setAccessible(true);
            System.out.println("Test method isNegative positive numer, number 5: " + isNegative.invoke(new Object(), 5));
            System.out.println("Test method isNegative negative numer, number -15: " + isNegative.invoke(new Object(), -15));

            Method printWelocome = cl.getDeclaredMethod("printWelocome", String.class);
            printWelocome.setAccessible(true);
            System.out.println("Test method printWelocome: ");
            printWelocome.invoke(new Object(), "Bob");


            Method isLeapYear = cl.getDeclaredMethod("isLeapYear", int.class);
            isLeapYear.setAccessible(true);
            System.out.println("Test method isLeapYear, year 2020: " + isLeapYear.invoke(new Object(), 2020));
            System.out.println("Next file");
            System.out.println();
        }
    }
}
