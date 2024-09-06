package com.lordbao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Lord_Bao
 * @Date 2024/9/6 9:56
 * @Version 1.0
 */
@SpringBootTest
public class AdvancedFeatureTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testLogicDelete(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAge,23);
        int rows = userMapper.delete(wrapper);
        if(rows>0){
            System.out.println("delete success");
        }else {
            System.out.println("delete failure");
        }
    }

    @Test
    public void testLogicDelete2(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testOptimismLock(){
        User user = userMapper.selectById(1831877315970965505L);
        User user1 = userMapper.selectById(1831877315970965505L);
        user.setEmail("jojo@qq.com");
        user1.setEmail("jojoland@qq.com");


        userMapper.updateById(user);
        //wrong!
        userMapper.updateById(user1);
    }
}
