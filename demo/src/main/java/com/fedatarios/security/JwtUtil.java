package com.fedatarios.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {

    private static final String KEY = "clave_secret";

    public String generateToken(UserDetails userDetails) {
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 20)) // Expira en 1 hora
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
        System.out.println("JWT: " + token);  // Agregar log para verificar
        return token;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
    }
}