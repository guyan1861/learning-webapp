package think.guyan.spring01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GuYan
 * @Time: 2022/8/29 23:04
 * @Description: Java 配置类的方式实现 Bean 配置
 **/

@Configuration
public class Account {

    @Bean
    public A getA() {
        return new A();
    }
}
