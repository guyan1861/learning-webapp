package think.in.base.java8stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 14:44
 * @Description: TODO
 **/
public class RandomGenerators {

    public static <T> void show(Stream<T> stream) {
        stream.limit(4).forEach(System.out::println);
        System.out.println("+++++++++++++");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        show(random.ints().boxed());
        show(random.longs().boxed());
        show(random.doubles().boxed());
        //设置上下边界
        show(random.ints(10, 20).boxed());
        show(random.longs(50, 100).boxed());
        show(random.doubles(20, 30).boxed());
        //设置流的大小
        show(random.ints(2).boxed());
        show(random.longs(2).boxed());
        show(random.doubles(2).boxed());
        //设置流的大小和边界
        show(random.ints(3, 3, 9).boxed());
        show(random.longs(3, 12, 22).boxed());
        show(random.doubles(3, 11.5, 12.3).boxed());
    }
}
