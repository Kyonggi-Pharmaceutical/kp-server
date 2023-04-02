package kr.ac.kgu.kpserver.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import kr.ac.kgu.kpserver.config.OAuth2Property;
import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtAuthenticator {

    private static final long TOKEN_VALIDITY = 86_400_000L;
    private static final long TOKEN_VALIDITY_REMEMBER = 2_592_000_000L;
    private final Key key;

    public JwtAuthenticator(OAuth2Property oAuth2Property) {
        this.key = Keys.hmacShaKeyFor(oAuth2Property.getJwtKey().getBytes());
    }

    public String createToken(User user, boolean rememberMe) {
        long now = (new Date()).getTime();
        Date expirationDate = new Date(now + (rememberMe ? TOKEN_VALIDITY_REMEMBER : TOKEN_VALIDITY));

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication verifyTokenAndGetAuthOrNull(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return new UsernamePasswordAuthenticationToken(claims.getSubject(), token, Collections.emptyList());
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

}
