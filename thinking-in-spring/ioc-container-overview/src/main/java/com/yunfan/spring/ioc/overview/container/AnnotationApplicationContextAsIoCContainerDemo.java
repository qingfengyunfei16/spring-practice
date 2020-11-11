package com.yunfan.spring.ioc.overview.container;

import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author Administrator
 * @description 注解能力 {@link org.springframework.context.ApplicationContext} 作为IoC容器示例
 * @create 2020/11/9 17:51
 * @since 1.0.0
 */
//@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 将当前类AnnotationApplicationContextAsIoCContainerDemo 作为配置类 （Configuration Class）
        annotationConfigApplicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文
        annotationConfigApplicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(annotationConfigApplicationContext);
        // 关闭应用上下文
        annotationConfigApplicationContext.close();

    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("小刘");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User集合对象：" +users);
        }
    }
}
