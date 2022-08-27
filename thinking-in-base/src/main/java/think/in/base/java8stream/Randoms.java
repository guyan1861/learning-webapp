package think.in.base.java8stream;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 13:57
 * @Description: TODO
 **/
public class Randoms {
    public static void main(String[] args) {
        //new Random(47)
        //        .ints(5,20)
        //        .distinct()
        //        .limit(7)
        //        .sorted()
        //        .forEach(System.out::println);

        Random random = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int i = random.nextInt(20);
            if(i < 5) {
                continue;
            }
            rints.add(i);
        }
        System.out.println(rints);
    }
}
