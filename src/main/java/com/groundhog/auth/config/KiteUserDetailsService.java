package com.groundhog.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groundhog.auth.dao.OauthUserAccountMapper;
import com.groundhog.auth.model.dto.SecurityUserDetails;
import com.groundhog.auth.model.dto.SecurityUserRole;
import com.groundhog.auth.model.entity.OauthUserAccount;
import com.groundhog.base.excption.GroundhogBizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * KiteUserDetailsService
 *
 * @author guotianyu
 * @date 2021/9/14
 */
@Slf4j
@Component(value = "kiteUserDetailsService")
public class KiteUserDetailsService implements UserDetailsService {
    @Resource
    private OauthUserAccountMapper oauthUserAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (StringUtils.isEmpty(username)) {
            throw new GroundhogBizException("用户id不能为空");
        }
        LambdaQueryWrapper<OauthUserAccount> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(OauthUserAccount::getUsername, username);
        OauthUserAccount oauthUserAccount = oauthUserAccountMapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(oauthUserAccount)) {
            throw new UsernameNotFoundException("未找到该用户");
        }

        // TODO 权限通过feign调用用户服务获取
        Set<SecurityUserRole> authorities = new HashSet<>();
        SecurityUserRole role = new SecurityUserRole("ROLE_ADMIN");
        authorities.add(role);

        // 返回自定义的 KiteUserDetails
        return SecurityUserDetails.builder()
                .securityUser(oauthUserAccount)
                .roleList(authorities).build();

    }
}
