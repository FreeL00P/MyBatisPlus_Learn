package com.atghuigu.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * SexyEnum
 *
 * @author fj
 * @date 2022/9/28 18:03
 */
@Getter
public enum SexyEnum {
    MALE(1,"男"),
    FEMALE(2,"女");
    @EnumValue //将注解所标识的属性的值存储到数据库中
    private Integer sex;
    private String sexName;
    SexyEnum(Integer sex,String sexName){
        this.sex = sex;
        this.sexName = sexName;
    }
}
