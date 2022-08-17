package com.rocket.laf.common;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class DefaultOAuth2UserExtention extends DefaultOAuth2User{

    public DefaultOAuth2UserExtention(Collection<? extends GrantedAuthority> authorities,
            Map<String, Object> attributes, String nameAttributeKey) {
        super(authorities, attributes, nameAttributeKey);
    }

    public String getUsername(){
        return super.getName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append("Username: ");
		sb.append(this.getName());
		sb.append(", Granted Authorities: [");
		sb.append(getAuthorities());
		sb.append("], User Attributes: [");
		sb.append(getAttributes());
		sb.append("]");
		return sb.toString();
    }
}
