package com.lordbao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Lord_Bao
 * @Date 2024/9/5 15:59
 * @Version 1.0
 */
@SpringBootTest
public class UpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUpdate(){

//        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
//        wrapper.eq("id",3).set("email",null).set("age",18);
//        int rows = userMapper.update(null, wrapper);
//        System.out.println(rows);

        User user = new User();
        user.setAge(18);
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",3).set("email",null);
        int rows = userMapper.update(user, wrapper);
        System.out.println(rows);
    }
}
