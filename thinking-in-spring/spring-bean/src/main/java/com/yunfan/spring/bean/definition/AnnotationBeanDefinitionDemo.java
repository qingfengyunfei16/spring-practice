package com.yunfan.spring.bean.definition;

import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Administrator
 * @description 注解 BeanDefinition 示例
 * @create 2020/11/12 17:13
 * @since 1.0.0
 */

// 3.通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class (配置类)
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过BeanDefinition 注册 API 方式实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(annotationConfigApplicationContext,"xiaowang-user");
        // 2.非命名 Bean的注册方式
        registerUserBeanDefinition(annotationConfigApplicationContext,null);


        // 启动应用上下文
        annotationConfigApplicationContext.refresh();
        // 按照Config类型依赖查找
        System.out.println("Config 类型的所有 Beans ：" + annotationConfigApplicationContext.getBeansOfType(Config.class));
        // 按照User类型依赖查找
        System.out.println("User 类型的所有 Beans ：" + annotationConfigApplicationContext.getBeansOfType(User.class));

        // 关闭应用上下文
        annotationConfigApplicationContext.close();
    }

    /**
     * Bean 的注册方式
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "小刘");
        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean的注册方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    /**
     * 非命名 Bean的注册方式
     * @param registry
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }



    // 2.通过 @Component 方式定义
    @Component // 定义当前类作为 Spring Bean (组件)
    public static class Config {
        // 1.通过 @Bean 方式定义
        @Bean(name = {"user", "xiaoliu-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小刘");
            return user;
        }
    }


}
