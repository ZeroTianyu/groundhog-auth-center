package com.groundhog.auth.service;

import com.groundhog.auth.model.vo.OauthUserRegisterVO;
import com.groundhog.security.model.entity.OauthUserAccount;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/09/14 16:06
 */
public interface OauthUserAccountService {
    /**
     * oauth用户注册
     * @param registerVO
     * @return
     */
     OauthUserAccount register(OauthUserRegisterVO registerVO);
}
