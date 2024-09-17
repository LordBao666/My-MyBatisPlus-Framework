package com.lordbao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lordbao.mapper.UserMapper;
import com.lordbao.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lord_Bao
 * @Date 2024/8/21 22:07
 * @Version 1.0
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(23);
        user.setName("joker");
        int row = userMapper.insert(user);
        System.out.println(row);
    }

    @Test
    public void testDelete(){
        //delete
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("age",23);
//        int rows = userMapper.delete(wrapper);

        //deleteById
//        int rows = userMapper.deleteById(1831543758006161410L);
//        Map<String,Object> map = new HashMap<>();

        //deleteByIds
//        List<Long> list = List.of(100L, 200L, 300L);
//        int rows = userMapper.deleteByIds(list);

        //deleteByMap
//        Map<String, Object> map = new HashMap<>();
//        map.put("age",23);
//        userMapper.deleteByMap(map);
    }

    @Test
    public void testUpdate(){
        //update
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("age",23);
        User user = new User();
        user.setEmail("jojoland@gmail.com");
        int rows = userMapper.update(user, updateWrapper);
        if(rows>0){
            System.out.println("update success");
        }else {
            System.out.println("update failure");
        }

        //updateById
//        User user = new User();
//        user.setEmail("jojo@qq.com");
//        user.setId(1826437681678721025L);
//        userMapper.updateById(user);
    }


    @Test
    public void testSelect(){
        //selectById selectOne selectBatchIds selectList is omitted

        //selectByMap
        // 假设有一个 columnMap，设置查询条件为 age = 30，查询满足条件的用户
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("age", 30);
//        List<User> users = userMapper.selectByMap(columnMap); // 调用 selectByMap 方法
//        for (User u : users) {
//            System.out.println("User: " + u);
//        }

        //selectMaps
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.gt("age", 20);
//        List<Map<String, Object>> userMaps = userMapper.selectMaps(queryWrapper); // 调用 selectMaps 方法
//        for (Map<String, Object> userMap : userMaps) {
//            System.out.println("User Map: " + userMap);
//        }

        //selectObjs
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.gt("age", 20);
//        List<Object> userIds = userMapper.selectObjs(queryWrapper); // 调用 selectObjs 方法
//        for (Object userId : userIds) {
//            System.out.println("User ID: " + userId);
//        }
    }
    @Test
    public void testPage(){
        //the first parameter is the current page you want to loop up,
        //the second parameter is the size of each page
        Page<User> p = new Page<>(5,2);
        userMapper.selectPage(p, null);
        List<User> userList = p.getRecords();
        System.out.println(userList);
        //long: current page,the first parameter of Page's constructor above
        System.out.println(p.getCurrent());
        //long: the size of each page, the second parameter  of Page's constructor above
        System.out.println(p.getSize());
        System.out.println(p.getPages());//long: the total number of pages
        System.out.println(p.getTotal());//long: the total number of records
        System.out.println(p.hasPrevious());//a boolean shows if p has previous page
        System.out.println(p.hasNext());//a boolean shows if p has next page
    }
}
