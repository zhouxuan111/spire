package com.zx.spire.clone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouxuan
 * @date 2021/1/27 4:35 下午
 */
@Data
public class Address {

    private String province;

    private String city;


    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }
}
