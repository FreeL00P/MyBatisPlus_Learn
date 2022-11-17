package com.atghuigu.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atghuigu.mybatisplus.pojo.Product;
import com.atghuigu.mybatisplus.service.ProductService;
import com.atghuigu.mybatisplus.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 86185
* @description 针对表【product】的数据库操作Service实现
* @createDate 2022-09-28 19:49:26
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




