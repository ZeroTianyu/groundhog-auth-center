package com.groundhog.auth;

import com.alibaba.fastjson.JSON;
import com.groundhog.auth.dao.OauthUserAccountMapper;
import com.groundhog.auth.model.entity.OauthUserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AuthApplicationTests {

    @Resource
    private OauthUserAccountMapper oauthUserAccountMapper;
    @Test
    void contextLoads() {

    }


    @Test
    public void testSelect(){
        OauthUserAccount oauthUserAccountMapper = this.oauthUserAccountMapper.selectById(1);
        System.out.println(JSON.toJSONString(oauthUserAccountMapper));
    }

}
