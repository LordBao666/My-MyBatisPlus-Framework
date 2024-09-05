package com.lordbao;

import com.lordbao.pojo.User;
import com.lordbao.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/22 12:18
 * @Version 1.0
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testList(){
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }
}
