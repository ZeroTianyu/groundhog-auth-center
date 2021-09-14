package com.groundhog.auth.service.impl;

import com.groundhog.auth.dao.OauthUserAccountMapper;
import com.groundhog.auth.service.OauthUserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/09/14 16:06
 */
@Service
public class OauthUserAccountServiceImpl implements OauthUserAccountService {
    @Resource
    private OauthUserAccountMapper oauthUserAccountMapper;


}
