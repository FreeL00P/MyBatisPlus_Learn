package com.atghuigu.mybatisplus.mapper;

import com.atghuigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * UserMapper
 *
 * @author fj
 * @date 2022/9/25 17:42
 */
@Repository //标识为持久层组件
public interface UserMapper extends BaseMapper<User> {
    Map<String,Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatisPlus 提供的分页对象 必须放在第一个2参数位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}
