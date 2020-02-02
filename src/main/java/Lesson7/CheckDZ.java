package Lesson7;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class CheckDZ {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/GB study/JavaCore3/Chat/Files/HT7");
        String[] str = file.list();

        for (String o : str) {

            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            Class ch = URLClassLoader.newInstance(new URL[]{file.toURL()}).loadClass(mass[0]);
            Method[] methods = ch.getDeclaredMethods();
            System.out.println(methods.length);
//            Constructor constructor = ch.getConstructor(String.class);
//
//            Object test1 = constructor.newInstance("String");
//            Method m = ch.getDeclaredMethod("info");
//            m.invoke(test1);
        }
    }
}
