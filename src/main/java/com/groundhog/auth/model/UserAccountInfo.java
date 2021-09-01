package com.groundhog.auth.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author: guotianyu
 * @description:
 * @create: 2021/08/27 16:17
 */
@Data
@TableName("user_account_info")
public class UserAccountInfo {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;

    @TableField(exist = false)
    private Collection<? extends GrantedAuthority> role;
}
