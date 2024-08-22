package com.lordbao;

import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/21 22:07
 * @Version 1.0
 */
@SpringBootTest
public class SpringbootTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
