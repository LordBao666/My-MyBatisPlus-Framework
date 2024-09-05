package com.lordbao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Lord_Bao
 * @Date 2024/9/5 16:47
 * @Version 1.0
 */
@SpringBootTest
public class LambdaWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLambdaQueryWrapper(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName,"a")
                .gt(User::getAge,18);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper(){
        LambdaUpdateWrapper <User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(User::getEmail,"test3@qq.com")
                .eq(User::getId,3);

        userMapper.update(null,wrapper);
    }
}
