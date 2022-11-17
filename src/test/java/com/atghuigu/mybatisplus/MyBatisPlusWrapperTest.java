package com.atghuigu.mybatisplus;

import com.atghuigu.mybatisplus.mapper.UserMapper;
import com.atghuigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * MyBatisPlusWrapperTest
 *
 * @author fj
 * @date 2022/9/27 14:17
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","o")
                .between("age",20,30)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out ::println);
    }

    @Test
    public void test03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int ret = userMapper.delete(queryWrapper);
        System.out.println("ret = " + ret);
    }
    @Test
    public void test04(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        updateWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("张三");
        user.setEmail("1324234@134.com");
        int ret  = userMapper.update(user, updateWrapper);
        System.out.println("ret = " + ret);
    }

    @Test
    public void test06(){
        //组装select
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07() {
        //子查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        queryWrapper.inSql("id","select id from user");
        userMapper.selectList(queryWrapper);
        userList.forEach(System.out ::println);
    }

    @Test
    public void test08(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.like("name","a")
                    .isNull("email")
                    .and(i->i.gt("age",20));
        updateWrapper.set("age",22)
                     .set("email","1234542@gmai.com");
        userMapper.update(null,updateWrapper);

    }

    @Test
    public void test09() {
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test10(){
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //User::getName() 获取s实体类对应表的字段
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge,ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
}
