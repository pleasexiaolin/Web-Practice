package com.xiaolin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author lzh
 * @description: jwt的工具类
 * @date 2025/11/11 8:38
 */
public class JwtUtil {

    public static final String SECRET = "SHU=YE=JUN";

    private static final Long EXPIRATION = 60 * 60 * 24L; //过期时间24小时

    /**
     * 生成JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();

    }

    /**
     * 解析JWT令牌
     */
    public static Claims parseJWT(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

    }

}
