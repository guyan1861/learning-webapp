package think.in.base.java8stream;


import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 17:43
 * @Description: TODO
 **/
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if(optString.isPresent())
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
