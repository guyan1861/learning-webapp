package think.in.base.java8stream;

import java.util.stream.Stream;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 16:44
 * @Description: 流的判断和测试，很多看不懂的地方，实践和测试
 **/
public class PeekTest {
    public static void main(String[] args) {
        Stream.of("Well","OF","Good")
                .map(w -> w+" ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);

        System.out.println(Math.sqrt(4));
    }
}
