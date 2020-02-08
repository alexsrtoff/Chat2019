import Lesson6.MainClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class arrayTest {

    MainClass mainClass;
    @Before
    public void init(){
        mainClass = new MainClass();
    }

    @Test
    public void test(){
        Assert.assertTrue(mainClass.arrayTest(new int[]{1,1,1,4}));
    }
    @Test
    public void test1(){
        Assert.assertTrue(mainClass.arrayTest(new int[]{1,1,1,1}));
    }
    @Test
    public void test2(){
        Assert.assertTrue(mainClass.arrayTest(new int[]{4,4,4}));
    }
    @Test
    public void test3(){
        Assert.assertTrue(mainClass.arrayTest(new int[]{1,1,1,4,5}));
    }
    @Test
    public void test4(){
        Assert.assertFalse( mainClass.arrayTest(new int[]{1,1,5,4,1}));
    }
}
