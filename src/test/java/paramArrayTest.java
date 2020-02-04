import Lesson6.MainClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class paramArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{5,6}, new int[] {1,2,3,4,5,6}},
                {new int[]{5,6,7}, new int[] {1,2,3,4,5,6,7}},
                {new int[]{6}, new int[] {1,2,3,4,6}},
                {new int[]{5,6,9}, new int[] {1,2,3,4,5,6,9}},
                {new int[]{5,6}, new int[] {1,2,3,4,5}}
        });
    }
    private int[] a;
    private int[] b;

    public paramArrayTest(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    private MainClass mainClass;
    @Before
    public void unit(){
        mainClass = new MainClass();
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(a, mainClass.arrTest(b));
    }
}
