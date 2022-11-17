package com.atghuigu.mybatisplus;

import com.atghuigu.mybatisplus.mapper.UserMapper;
import com.atghuigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MybatisPlusTest
 *
 * @author fj
 * @date 2022/9/25 19:21
 */
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件查询一个list集合，若没有条件可以设NULL作为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out ::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张安");
        user.setAge(22);
        user.setEmail("adream@gmail.com");
        int ret = userMapper.insert(user);
        System.out.println("ret = " + ret);
        System.out.println("id="+user.getId());
    }
    @Test
    public void testDelete(){
//        int ret = userMapper.deleteById(1574028177009283073L);
        Map<String, Object> map = new HashMap();
        map.put("id","1");
        int ret = userMapper.deleteByMap(map);
        System.out.println("ret = " + ret);
    }


    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("张无");
        user.setAge(23);
        user.setEmail("adrea23213m@gmail.com");
        Map<String, Object> map = new HashMap();
    }

    @Test
    public void testSelectById(){
//        User user = userMapper.selectById(3L);
//        System.out.println("user = " + user);
        Map<String, Object> map = userMapper.selectMapById(3L);
        System.out.println("map = " + map);
    }
}
