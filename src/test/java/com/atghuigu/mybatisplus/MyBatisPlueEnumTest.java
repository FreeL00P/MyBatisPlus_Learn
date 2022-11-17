package com.atghuigu.mybatisplus;

import com.atghuigu.mybatisplus.enums.SexyEnum;
import com.atghuigu.mybatisplus.mapper.UserMapper;
import com.atghuigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MyBatisPlueEnumTest
 *
 * @author fj
 * @date 2022/9/28 18:58
 */
@SpringBootTest
public class MyBatisPlueEnumTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        User user =new User();
        user.setId(111L);
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexyEnum.MALE);
        int ret = userMapper.insert(user);
        System.out.println("ret = " + ret);
    }
}
