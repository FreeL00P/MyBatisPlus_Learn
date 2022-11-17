package com.atghuigu.mybatisplus.mapper;
import org.apache.ibatis.annotations.Param;

import com.atghuigu.mybatisplus.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 86185
* @description 针对表【product】的数据库操作Mapper
* @createDate 2022-09-28 19:49:26
* @Entity com.atghuigu.mybatisplus.pojo.Product
*/
public interface ProductMapper extends BaseMapper<Product> {
    @Override
    int insert(Product entity);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);
}




