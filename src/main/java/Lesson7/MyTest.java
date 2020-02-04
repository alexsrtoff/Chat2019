package Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class MyTest {
    public static void start(Class c, Object obj) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> methodArrayList = new ArrayList<>();
        int count_test = 0;
        int count_befor = 0;
        int count_after = 0;

        for (Method o : methods){
            if(o.isAnnotationPresent(BeforeSuite.class)){
                if (count_befor >= 1) throw new RuntimeException(" Before более одного");
                o.invoke(obj);
                count_befor++;
            }
        }

        for (Method o : methods){
            if(o.isAnnotationPresent(Test.class)){
                methodArrayList.add(o);
            }
        }

        Method[] methods_test = new Method[methodArrayList.size()];
        methodArrayList.toArray(methods_test);

        for (Method o: methods_test) {
            for (int i = 0; i < methods_test.length ; i++) {
                Method current = methods_test[i];
                int current_i = i;
                int priority = methods_test[i].getAnnotation(Test.class).priority();

                for(int j = i + 1; j < methods_test.length; j++){
                    int curr_priority = methods_test[j].getAnnotation(Test.class).priority();
                    if(priority < curr_priority){
                        current = methods_test[j];
                        current_i = j;
                    }
                }
                if(i != current_i){
                    Method tmp = methods_test[i];
                    methods_test[i] = methods_test[current_i];
                    methods_test[current_i] = tmp;
                }
            }
        }
        for (Method o: methods_test) {
            if (o.isAnnotationPresent(Test.class)) {
                System.out.println("Приоритет: " + o.getAnnotation(Test.class).priority());
                o.invoke(obj);
            }
        }

        for (Method o : methods){
            if(o.isAnnotationPresent(AfterSuite.class)){
                if (count_after >= 1) throw new RuntimeException("@AfterSuite более одногоо");
                o.invoke(obj);
                count_after++;
            }
        }
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        Dog dog = new Dog();
        try {
            start(Dog.class, dog);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
