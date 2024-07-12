import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        int expected = 19;
        int actual = new Solution().maximumGain(s, x, y);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        int expected = 20;
        int actual = new Solution().maximumGain(s, x, y);

        Assert.assertEquals(expected, actual);
    }
}
