import Lesson6.MainClass;
import org.junit.Assert;
import org.junit.Test;
public class arrTest {
    MainClass testArr;

    @Test
    public void test(){
        testArr = new MainClass();
        Assert.assertArrayEquals(new int[]{5, 6}, testArr.arrTest(new int[]{1,2,3,4,5,6}));
    }
    @Test
    public void test1(){
        testArr = new MainClass();
        Assert.assertArrayEquals(new int[]{5, 6}, testArr.arrTest(new int[]{1,4,3,4,5,6}));
    }
    @Test
    public void test2(){
        testArr = new MainClass();
        Assert.assertArrayEquals(new int[]{5, 6, 7, 9}, testArr.arrTest(new int[]{1,2,3,4,5,6,7,9}));
    }
    @Test
    public void test3(){
        testArr = new MainClass();
        Assert.assertArrayEquals(new int[]{9}, testArr.arrTest(new int[]{1,4,3,4,5,6,4,9}));
    }
    @Test
    public void test4(){
        testArr = new MainClass();
        Assert.assertArrayEquals(new int[]{9}, testArr.arrTest(new int[]{1,4,3,4,5,6,9}));
    }

}
