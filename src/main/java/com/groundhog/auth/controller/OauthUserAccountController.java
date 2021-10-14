package com.groundhog.auth.controller;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/08/31 22:26
 */

import com.groundhog.auth.model.vo.OauthUserRegisterVO;
import com.groundhog.auth.service.OauthUserAccountService;
import com.groundhog.base.model.vo.GroundhogResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class OauthUserAccountController {

    @Resource
    private OauthUserAccountService oauthUserAccountService;


    @GetMapping("/register")
    public GroundhogResult register(@Valid @RequestBody OauthUserRegisterVO oauthUserRegisterVO){
        return GroundhogResult.success(oauthUserAccountService.register(oauthUserRegisterVO));
    }

}
