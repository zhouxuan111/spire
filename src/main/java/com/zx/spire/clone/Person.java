package com.zx.spire.clone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouxuan
 * @date 2021/1/27 4:34 下午
 */
@Getter
@Setter
public class Person implements Cloneable {

    private String name;

    private Address address;

    private Integer age;

    public Person() {

    }


    public Person(String name, Address address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    /**
     *  Object的clone()方式是创建对象的一种方式
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
