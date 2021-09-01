package com.groundhog.auth.config;

import com.groundhog.auth.dao.UserAccountInfoMapper;
import com.groundhog.auth.model.UserAccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author guotianyu
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Resource
    private UserAccountInfoMapper userAccountInfoMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class, readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("查询用户信息，username:{}", username);
        UserAccountInfo userAccountInfo = userAccountInfoMapper.selectById(1);

        return new org.springframework.security.core.userdetails.User(userAccountInfo.getUsername(), new BCryptPasswordEncoder().encode(userAccountInfo.getPassword()), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}