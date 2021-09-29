package com.groundhog.auth.config;

import com.groundhog.security.model.dto.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author guotianyu
 */
@Service
public class UserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap();
        SecurityUserDetails principal = (SecurityUserDetails) authentication.getPrincipal();
        principal.getSecurityUser().setPassword(null);
        response.put(UserAuthenticationConverter.USERNAME, principal);
        return response;
    }
}