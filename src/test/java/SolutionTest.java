import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1() {
        int n = 2;
        List<String> logs = new ArrayList<>(List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        int[] expected = {3, 4};
        int[] actual = new Solution().exclusiveTime(n, logs);

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void test2() {
        int n = 1;
        List<String> logs = new ArrayList<>(List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
        int[] expected = {8};
        int[] actual = new Solution().exclusiveTime(n, logs);

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void test3() {
        int n = 2;
        List<String> logs = new ArrayList<>(List.of("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"));
        int[] expected = {7, 1};
        int[] actual = new Solution().exclusiveTime(n, logs);

        Assert.assertArrayEquals(expected, actual);

    }
}
