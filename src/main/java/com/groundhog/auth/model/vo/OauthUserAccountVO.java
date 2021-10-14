package com.groundhog.auth.model.vo;

import lombok.Data;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/10/12 15:00
 */
@Data
public class OauthUserAccountVO {
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
     * 密码（BCrypt）
     */
    private String password;

    /**
     * 状态(0禁用，1启用)
     */
    private Boolean status;
}
