package org.engripaye.oauth2resourceserver.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomJwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public @NonNull AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = jwt.getClaimAsStringList("roles");

        if (roles != null) {
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
