package think.guyan.spring01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

/**
 * @Author: GuYan
 * @Time: 2022/8/29 21:40
 * @Description: 配置文件方式实现
 **/
//@Component
//@Service
//@Repository
@Controller
public class A implements ApplicationContextAware, BeanNameAware {

    private String beanName;
    private ApplicationContext applicationContext;

    private Student student;

    @Autowired
    @Qualifier("s1")
    public void setStudent(Student student) {
        this.student = student;
    }

    public void print(String s) {
        System.out.println(s);
        System.out.println(student);
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return "A{" + "beanName='" + beanName + '\'' + ", applicationContext=" + applicationContext + '}';
    }
}
