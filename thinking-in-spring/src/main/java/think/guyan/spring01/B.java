package think.guyan.spring01;

import org.springframework.stereotype.Component;

/**
 * @Author: GuYan
 * @Time: 2022/8/29 22:52
 * @Description: TODO
 **/
@Component
public class B {
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        a.toString();
        return "B{" + "a=" + a + '}';
    }
}
