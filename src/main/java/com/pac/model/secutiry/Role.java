package com.pac.model.secutiry;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
    USER_ROLE(Set.of(Permission.READ)),
    DRIVER_ROLE(Set.of(Permission.READ, Permission.UPDATE)),
    ADMIN_ROLE(Set.of(Permission.READ, Permission.UPDATE, Permission.WRITE, Permission.DELETE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
