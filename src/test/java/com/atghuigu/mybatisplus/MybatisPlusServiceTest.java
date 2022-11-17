package com.atghuigu.mybatisplus;

import com.atghuigu.mybatisplus.pojo.User;
import com.atghuigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * MybatisPlueServiceTest
 *
 * @author fj
 * @date 2022/9/26 11:15
 */
@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("count = " + count);
    }

//    @Test
//    public void testInsertMore() {
//        List<User> userList = Arrays.asList(new User(40L,"1",1,"1",null),
//                                            new User(50L,"2",2,"2",null),
//                                            new User(60L,"3",3,"3",null));
//        userService.saveBatch(userList,2);
//    }


}
