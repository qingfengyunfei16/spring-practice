package com.yunfan.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @description
 * @create 2020/11/6 15:42
 * @since 1.0.0
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        //使用javabean  内省方式加载信息Person  后面的Object 是stopClass  方式父类中一些get set 方法被反射解析到
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
            .forEach(propertyDescriptor -> {
                //打印属性信息
                System.out.println(propertyDescriptor);

                //PropertyDescriptor 允许添加属性编辑器  - PropertyEditor
                //GUI -> text(String) -> PropertyType
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                String propertyName = propertyDescriptor.getName();
                if("age".equals(propertyName)) { //为"age" 字段增加PorpertyEditor
                    //String -> Integer
                    propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                    propertyDescriptor.createPropertyEditor();
                }

            });
        ;
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
