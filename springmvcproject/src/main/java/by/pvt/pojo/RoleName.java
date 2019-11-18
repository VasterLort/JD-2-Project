package by.pvt.pojo;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
