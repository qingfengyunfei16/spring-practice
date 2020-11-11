package com.yunfan.spring.ioc.overview.dependency.injection;

import com.yunfan.spring.ioc.overview.annotation.Super;
import com.yunfan.spring.ioc.overview.domain.User;
import com.yunfan.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author Administrator
 * @description 依赖注入示例
 *
 * 1、通过名称的方式来注入
 * 2、通过类型的方式来注入
 * 3、通过注解的方式来注入
 *
 * @create 2020/11/9 11:07
 * @since 1.0.0
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置XML 配置文件
        // 启动Spring应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 1、自定义bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        // 2、依赖注入 （内建依赖）
        System.out.println(userRepository.getBeanFactory());

        //这个表达式为什么是 false
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = userRepository.getUserObjectFactory();
        System.out.println(userFactory.getObject());
        System.out.println(userFactory.getObject() == applicationContext);

        // 3、容器内建Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean" + environment);
    }

    private static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {
        //这个表达式为什么是 false
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()

        // ApplicationContext is BeanFactory



    }
}
