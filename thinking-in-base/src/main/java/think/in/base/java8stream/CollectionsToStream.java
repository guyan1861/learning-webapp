package think.in.base.java8stream;

import java.util.*;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 14:28
 * @Description: 集合
 **/
public class CollectionsToStream {
    public static void main(String[] args) {
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(bubbles.stream().mapToInt(b -> b.i).sum());

        HashSet<String> v = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        v.stream().map(x -> x + " ").forEach(System.out::print);
        System.out.println();
        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(System.out::println);
    }
}
