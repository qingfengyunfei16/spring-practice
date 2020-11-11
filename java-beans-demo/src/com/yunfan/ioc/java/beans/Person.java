package com.yunfan.ioc.java.beans;

/**
 * @author Administrator
 * @description 描述人的 POJO 贫血模型
 *
 * Setter / Getter 方法
 * 又称为 可写方法(Writable) / 可读方法(Readable)
 *
 * @create 2020/11/6 15:32
 * @since 1.0.0
 */
public class Person {

    /**
     * 姓名  又称为 Property
     */
    String name;

    /**
     * 年龄
     */
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
