package think.in.base.java8stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 18:00
 * @Description: TODO
 **/
public class RandInts {
    public static int[] rints = new Random(47).ints(0, 1000).limit(10).toArray();

    public static IntStream rands() {
        return Arrays.stream(rints);
    }

    public static void main(String[] args) {
        rands().forEach(n -> System.out.format("%d ", n));
    }
}
