package com.yunfan.spring.ioc.overview.domain;

import com.yunfan.spring.ioc.overview.annotation.Super;

/**
 * @author Administrator
 * @description 超级用户
 * @create 2020/11/9 15:07
 * @since 1.0.0
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
