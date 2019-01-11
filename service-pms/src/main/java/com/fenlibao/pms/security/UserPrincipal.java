package com.fenlibao.pms.security;

import com.fenlibao.pms.model.bo.idmt.RoleBO;
import com.fenlibao.pms.model.bo.idmt.UserBO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Data
@SuppressWarnings("unchecked")
public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 5864559592637074945L;
    private UserBO userBO;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(UserBO userBO) {
        this.userBO = userBO;
    }

    public UserPrincipal(UserBO userBO, Collection authorities) {
        this.userBO = userBO;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserBO userBO) {
        Collection<GrantedAuthority> authorities = new ArrayList();
        userBO.getUserRoles().forEach(role -> {
            RoleBO roleBO = role.getRole();
            if (roleBO != null) {
                roleBO.getRolePermission().forEach(
                        permission -> {
                            if (permission != null && permission.getPermission() != null && permission.getPermission().getCode() != null) {
                                authorities.add(new SimpleGrantedAuthority(permission.getPermission().getCode()));
                            }
                        });
            }
        });
        return new UserPrincipal(userBO, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.userBO.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userBO.getUserName();
    }

    public Integer getId() {
        return this.userBO.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
