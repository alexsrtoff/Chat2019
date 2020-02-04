package Lesson7;

public class Dog {

    @Test (priority = 1)
    public void run(){
        System.out.println("Dog run");
    }

    @Test (priority = 2)
    public void sleep(){
        System.out.println("sleep");
    }

    @Test
    public void jump(){
        System.out.println("jump");
    }

    @AfterSuite
    public void end(){
        System.out.println("Конец теста");
    }

//    @AfterSuite
//    public void end1(){
//        System.out.println("Конец теста @AfterSuite более одного");
//    }

    @BeforeSuite
    public void start(){
        System.out.println("Начало теста");
    }

//    @BeforeSuite
//    public void start1(){
//        System.out.println("Начало теста второй before");
//    }


}
