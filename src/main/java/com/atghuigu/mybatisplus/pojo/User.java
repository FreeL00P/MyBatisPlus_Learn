package com.atghuigu.mybatisplus.pojo;

import com.atghuigu.mybatisplus.enums.SexyEnum;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 * @author fj
 * @date 2022/9/25 17:34
 */
@Data //lombok注解
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic //逻辑删除字段
    private Integer isDeleted;
    private SexyEnum sex;
}
