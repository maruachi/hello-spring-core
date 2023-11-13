package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singleton1 = ac.getBean(SingletonBean.class);
        SingletonBean singleton2 = ac.getBean(SingletonBean.class);

        System.out.println("singleton1 = " + singleton1);
        System.out.println("singleton2 = " + singleton2);

        Assertions.assertThat(singleton1).isSameAs(singleton2);
    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init() {
            System.out.println("singletonBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("singletonBean.destroy");
        }

    }
}
