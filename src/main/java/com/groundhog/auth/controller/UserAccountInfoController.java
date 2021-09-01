package com.groundhog.auth.controller;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/08/31 22:26
 */

import com.groundhog.auth.dao.UserAccountInfoMapper;
import com.groundhog.auth.model.UserAccountInfo;
import com.groundhog.base.model.GroundhogResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserAccountInfoController {

    @Resource
    private UserAccountInfoMapper userAccountInfoMapper;
    @GetMapping("/getuser")
    public GroundhogResult getUser(){
        UserAccountInfo userAccountInfo = userAccountInfoMapper.selectById(1);
        return GroundhogResult.success(userAccountInfo);
    }

}
