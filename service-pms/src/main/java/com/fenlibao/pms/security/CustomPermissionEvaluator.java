package com.fenlibao.pms.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator{

    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        if ((authentication == null) || (o == null) || !(o1 instanceof String)){
            return false;
        }
        return hasPrivilege(authentication,o.toString(), o1.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        /*
         * not supported
         */
        return false;
    }

    private boolean hasPrivilege(Authentication auth,String targetType, String permission) {
        for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
            if (grantedAuth.getAuthority().startsWith(targetType) && grantedAuth.getAuthority().contains(permission)) {
                return true;
            }
        }
        return false;
    }
}
