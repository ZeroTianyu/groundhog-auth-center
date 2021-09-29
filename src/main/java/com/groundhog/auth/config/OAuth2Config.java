package com.groundhog.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * oauth配置类
 *
 * @author guotianyu
 * @date 2021/9/14
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Resource
    public UserDetailsService kiteUserDetailsService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenStore redisTokenStore;

    @Resource
    private DataSource dataSource;

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        defaultAccessTokenConverter.setUserTokenConverter(new UserAuthenticationConverter());
        /**
         * redis token 方式
         */
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(kiteUserDetailsService)
                .accessTokenConverter(defaultAccessTokenConverter)
                .tokenStore(redisTokenStore);

        //token 增强器
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(new ArrayList<>(tokenEnhancers));

        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        //设置重用刷新令牌
        defaultTokenServices.setReuseRefreshToken(true);
        //设置支持刷新令牌
        defaultTokenServices.setSupportRefreshToken(true);
        // Token存储
        defaultTokenServices.setTokenStore(redisTokenStore);
        // 设置访问令牌有效秒
//        defaultTokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds);

        //设置刷新令牌有效秒
//        defaultTokenServices.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);

    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("isAuthenticated()");
    }
}