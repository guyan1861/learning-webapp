package think.guyan.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: GuYan
 * @Time: 2022/8/29 21:18
 * @Description: TODO
 **/
public class SpringDemo1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-beans.xml");
        Student s1 = (Student) context.getBean("s1");
        System.out.println(s1.getName());
        Student s2 = (Student) context.getBean("s2");
        System.out.println(s2.getName());
        System.out.println(s1 == s2);

        A a = (A) context.getBean("a");
        a.print("hello world");
        System.out.println(a);
        B b = (B) context.getBean("b");
        System.out.println(b.toString());
    }
}
