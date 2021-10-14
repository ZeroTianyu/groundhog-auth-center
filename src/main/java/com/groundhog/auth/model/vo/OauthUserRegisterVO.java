package com.groundhog.auth.model.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author: guotianyu
 * @description:    注册用户请求vo
 * @create: 2021/10/12 15:12
 */
@Data
public class OauthUserRegisterVO {
    /**
     * 用户名
     */
    @Pattern(regexp = "/^[a-zA-Z][a-zA-Z0-9]{3,15}$/",message = "用户名不符合规范,仅支持数字,字符.长度3-15")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 用户类型
     */
    @NotEmpty(message = "用户类型不能为空")
    private String userType;
}
