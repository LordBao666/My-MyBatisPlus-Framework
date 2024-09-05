package com.lordbao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author Lord_Bao
 * @Date 2024/8/22 15:43
 * @Version 1.0
 */
@SpringBootTest
public class QueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        //select * from user
        //where name like '%a%'
        //and age between 20 and 30
        //and email is not null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","a").
                between("age",20,30).
                isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testOrder(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    public void testOr(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","a")
                .gt("age",20)
                .or()
                .isNull("email");

        List<User> list = userMapper.selectList(userQueryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void testSelect(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("name","age");

        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        for(Map<String, Object> map:maps){
            System.out.println(map);
        }

    }

    @Test
    public void  testCondition(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        int age=24;
        userQueryWrapper.like(age>18,"name","a");
        userMapper.selectList(userQueryWrapper).forEach(System.out::println);
    }
}
