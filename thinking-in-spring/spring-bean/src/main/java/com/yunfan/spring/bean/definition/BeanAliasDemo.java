package com.yunfan.spring.bean.definition;

import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @description Bean 别名示例
 * @create 2020/11/12 17:04
 * @since 1.0.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置XML 配置文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 xiaowang-user 获取曾用名 user 的bean
        User user = beanFactory.getBean("user", User.class);
        User xiaowangUser = beanFactory.getBean("xiaowang-user", User.class);
        System.out.println("user和xiaowang-user是否相同的bean : " + (user == xiaowangUser));

    }
}
