package com.atghuigu.mybatisplus;

import com.atghuigu.mybatisplus.mapper.ProductMapper;
import com.atghuigu.mybatisplus.mapper.UserMapper;
import com.atghuigu.mybatisplus.pojo.Product;
import com.atghuigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * MyBatisPlusPluginsTest
 *
 * @author fj
 * @date 2022/9/27 20:36
 */
@Slf4j
@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        log.info("userPage = " + userPage);
        log.info("page.getRecords = "+page.getRecords());
        log.info("page.getCurrent() = " + page.getCurrent());
        log.info("page.getSize() = " + page.getSize());
        log.info("page.getTotal() = " + page.getTotal());
        log.info("page.getPages() = " + page.getPages());
    }

    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page,20);
    }
    @Test
    public void testProduct01(){
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productWang.getPrice());

        //3.小李修改商品价格+50
        productLi.setPrice(productLi.getPrice()+50);
        int ret = productMapper.updateById(productLi);
        System.out.println("小李修改商品价格 " + ret);
        //4.小王修改商品价格-30
        productWang.setPrice(productWang.getPrice()-30);
        int ret1 = productMapper.updateById(productWang);
        System.out.println("小王修改商品价格  " + ret1);
        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }
}
