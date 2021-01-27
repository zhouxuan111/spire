package com.zx.spire.clone;

import java.time.Period;

/**
 * @author zhouxuan
 * @date 2021/1/27 4:37 下午
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person = new Person();
        person.setAge(1);
        person.setName("test");
        Address address = new Address("辽宁", "丹东");
        person.setAddress(address);

        System.out.println(person.getName() + "__"+person.getAddress().hashCode());
        System.out.println("person:"+person.getAddress());
        Person clone = (Person) person.clone();
        System.out.println(clone.getName()+"__"+clone.getAddress().hashCode());
        System.out.println("clone:"+clone.getAddress());

        address.setCity("沈阳");
        clone.setAddress(address);
        System.out.println("clone:"+clone);
        System.out.println("person:"+person);
    }
}
