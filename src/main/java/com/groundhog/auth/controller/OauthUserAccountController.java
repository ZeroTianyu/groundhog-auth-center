package com.groundhog.auth.controller;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/08/31 22:26
 */

import com.groundhog.auth.dao.OauthUserAccountMapper;
import com.groundhog.auth.model.entity.OauthUserAccount;
import com.groundhog.base.model.vo.GroundhogResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OauthUserAccountController {

    @Resource
    private OauthUserAccountMapper oauthUserAccountMapper;
    @GetMapping("/getuser")
    public GroundhogResult getUser(){
        OauthUserAccount oauthUserAccount = oauthUserAccountMapper.selectById(1);
        return GroundhogResult.success(oauthUserAccount);
    }

}
