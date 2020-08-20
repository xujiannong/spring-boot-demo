package com.example.redis;

import com.example.redis.model.User;
import com.example.redis.tools.RedisCache;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    RedisCache redisCache;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void getValue() throws Exception {
        boolean exists = redisTemplate.hasKey("user-key");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        System.out.println(stringRedisTemplate.opsForValue().get("user-key::com.example.redis.web.UserControllergetUser").toString());
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 100, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

    @Test
    public void redisTest() throws Exception {
        //定义User
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
        //缓存基本的对象，Integer、String、实体类等
        ValueOperations<String, User> operation = redisTemplate.opsForValue();
        operation.set("user_String", user);
        operation.set("user_String_1seconds", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        System.out.println(redisTemplate.opsForValue().get("user_String").toString());
        boolean exists = redisTemplate.hasKey("user_String_1seconds");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        //删除key
        redisTemplate.delete("user_String");
        //缓存List数据
        List<User> dataList = new ArrayList<>();
        dataList.add(user);
        dataList.add(user);
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.leftPush("user_List", dataList.get(i));
            }
        }

        Long size = listOperation.size("user_List");
        List<Object> dataListReturn = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            dataListReturn.add(listOperation.index("user_List", i));
        }
        System.out.println(dataListReturn);
        //缓存Set
        Set<String> dataSet = new HashSet<>();
        dataSet.add("0");
        dataSet.add("1");
        dataSet.add("3");
        dataSet.add("4");
        dataSet.add("5");
        BoundSetOperations<String, String> setOperation = redisTemplate.boundSetOps("user_Set");
        Iterator<String> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        Set<Object> dataSetReturn = new HashSet<Object>();
        dataSet = setOperation.members();
        System.out.println(dataSet);
        //缓存Map
        Map<String, User> dataMap = new HashMap<>();
        dataMap.put("user",user);
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap)
        {
            for (Map.Entry<String, User> entry : dataMap.entrySet())
            {
                hashOperations.put("user_Map", entry.getKey(), entry.getValue());
            }
        }

        Map<String, User> dataMapTeturn = hashOperations.entries("user_Map");
        System.out.println(dataMapTeturn);
    }
}