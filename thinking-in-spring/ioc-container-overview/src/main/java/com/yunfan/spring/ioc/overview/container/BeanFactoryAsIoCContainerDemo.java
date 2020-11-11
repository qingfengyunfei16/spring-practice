package com.yunfan.spring.ioc.overview.container;

import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author Administrator
 * @description IoC 容器示例
 * @create 2020/11/9 17:51
 * @since 1.0.0
 */
public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 获取xml配置路径 ClassPath 路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";

        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);

        // 依赖查找集合对象
        lookupCollectionByType(beanFactory);


    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User集合对象：" +users);
        }
    }
}
