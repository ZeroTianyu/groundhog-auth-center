package com.groundhog.auth.service.impl;

import com.groundhog.auth.dao.OauthUserAccountMapper;
import com.groundhog.auth.model.vo.OauthUserRegisterVO;
import com.groundhog.auth.service.OauthUserAccountService;
import com.groundhog.security.model.entity.OauthUserAccount;
import com.groundhog.utils.common.SnowFlake;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/09/14 16:06
 */
@Service
public class OauthUserAccountServiceImpl implements OauthUserAccountService {
    @Resource
    private OauthUserAccountMapper oauthUserAccountMapper;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    /**
     * oauth用户注册
     * @param registerVO
     * @return
     */
    @Override
    public OauthUserAccount register(OauthUserRegisterVO registerVO) {
        OauthUserAccount oauthUserAccount = new OauthUserAccount();
        long userId = SnowFlake.nextId();
        oauthUserAccount.setUserId(userId);
        oauthUserAccount.setUsername(registerVO.getUsername());
        // 普通用户
        oauthUserAccount.setUserType(registerVO.getUserType());
        oauthUserAccount.setPassword(passwordEncoder.encode(registerVO.getPassword()));
        oauthUserAccount.setStatus(Boolean.TRUE);
        oauthUserAccount.setCreateTime(LocalDateTime.now());
        oauthUserAccount.setCreateUserId(userId);
        oauthUserAccount.setCreateUserName(registerVO.getUsername());
        oauthUserAccount.setUpdateTime(LocalDateTime.now());
        oauthUserAccount.setUpdateUserId(userId);
        oauthUserAccount.setUpdateUserName(registerVO.getUsername());

        oauthUserAccountMapper.insert(oauthUserAccount);

        return oauthUserAccount;
    }
}
