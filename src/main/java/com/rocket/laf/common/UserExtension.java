package com.rocket.laf.common;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserExtension extends User{

    private long userNo;

    public UserExtension(String username, String password, Collection<? extends GrantedAuthority> authorities,
            long userNo) {
        super(username, password, authorities);
        this.userNo = userNo;
    }

    public UserExtension(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            long userNo) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userNo = userNo;
    }

    public long getUserNo(){
        return this.userNo;
    }

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName()).append(" [");
		sb.append("Username=").append(this.getUsername()).append(", ");
		sb.append("Password=[PROTECTED], ");
		sb.append("Enabled=").append(this.isEnabled()).append(", ");
		sb.append("AccountNonExpired=").append(this.isAccountNonExpired()).append(", ");
		sb.append("credentialsNonExpired=").append(this.isCredentialsNonExpired()).append(", ");
		sb.append("AccountNonLocked=").append(this.isAccountNonLocked()).append(", ");
		sb.append("Granted Authorities=").append(this.getAuthorities()).append(", ");
        sb.append("UserNumber=").append(this.getUserNo()).append("]");
		return sb.toString();
	}
    

}