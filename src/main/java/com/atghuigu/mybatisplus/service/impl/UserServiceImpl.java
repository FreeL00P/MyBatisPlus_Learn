package com.atghuigu.mybatisplus.service.impl;

import com.atghuigu.mybatisplus.mapper.UserMapper;
import com.atghuigu.mybatisplus.pojo.User;
import com.atghuigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author fj
 * @date 2022/9/26 11:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
