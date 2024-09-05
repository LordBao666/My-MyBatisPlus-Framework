package com.lordbao.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lordbao.pojo.User;
import com.lordbao.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author Lord_Bao
 * @Date 2024/8/22 11:12
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>,User> implements UserService {
}
