package think.in.base.java8stream;

/**
 * @Author: GuYan
 * @Time: 2022/8/27 14:19
 * @Description: TODO
 **/
public class Bubble {
    public final int i;

    public Bubble(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")";
    }

    private static int count = 0;

    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}
