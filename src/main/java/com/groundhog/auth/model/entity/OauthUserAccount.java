package com.groundhog.auth.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.groundhog.base.model.dto.GroundhogBaseEntity;
import lombok.Data;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/08/27 16:17
 */
@Data
@TableName("oauth_user_account")
public class OauthUserAccount extends GroundhogBaseEntity {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 账号类型
     */
    private String accountType;

    /**
     * 账号前缀
     */
    private String account;

    /**
     * 账号密文
     */
    private String accountFull;


    /**
     * 密码（BCrypt）
     */
    private String password;

    /**
     * 状态(0禁用，1启用)
     */
    private Boolean status;

    /**
     * 账号对应名称
     */
    private String accountName;


}
