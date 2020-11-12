package com.yunfan.spring.bean.definition;

import com.yunfan.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author Administrator
 * @description
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @create 2020/11/12 11:06
 * @since 1.0.0
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id",1);
        beanDefinitionBuilder.addPropertyValue("name","小王");
        // 获取BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非Bean 终态 可以自定义修改


        // 2.通过 AbstractBeanDefinition 以及其派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues 批量操作属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        // 通过 addPropertyValue  批量操作属性
//        mutablePropertyValues.addPropertyValue("id",1);
//        mutablePropertyValues.addPropertyValue("name","小王");
        // 通过 add 建造者模式 批量操作属性
        mutablePropertyValues.add("id",1).add("name","小王");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

    }
}
