package com.groundhog.auth;

import com.alibaba.fastjson.JSON;
import com.groundhog.auth.dao.UserAccountInfoMapper;
import com.groundhog.auth.model.UserAccountInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AuthApplicationTests {

    @Resource
    private UserAccountInfoMapper userAccountInfoMapper;
    @Test
    void contextLoads() {

    }


    @Test
    public void testSelect(){
        UserAccountInfo userAccountInfoMapper = this.userAccountInfoMapper.selectById(1);
        System.out.println(JSON.toJSONString(userAccountInfoMapper));
    }

}
