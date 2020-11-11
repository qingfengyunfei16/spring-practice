package com.yunfan.spring.ioc.overview.dependency.lookup;

import com.yunfan.spring.ioc.overview.annotation.Super;
import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author Administrator
 * @description 依赖查找示例
 *
 * 1、通过名称的方式来查找
 * 2、通过类型的方式来查找
 * 3、通过注解的方式来查找
 * @create 2020/11/9 11:07
 * @since 1.0.0
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置XML 配置文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
//        // 实时查找Bean
//        lookupInRealTime(beanFactory);
//        // 延迟查找Bean
//        lookupInLazy(beanFactory);
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找集合对象
        lookupCollectionByType(beanFactory);
        // 按照注解查找
        lookupByAnnotationType(beanFactory);
        
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有User集合对象：" + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User集合对象：" +users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean(User.class);
        System.out.println("按类型实时查找: "+user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = userObjectFactory.getObject();
        System.out.println("按名称延迟查找: "+user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("按名称实时查找: "+user);
    }
}
