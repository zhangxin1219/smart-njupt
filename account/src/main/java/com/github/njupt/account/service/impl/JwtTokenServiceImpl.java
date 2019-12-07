package com.github.njupt.account.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.njupt.account.service.TokenService;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 12:43
 * @Description:
 */
@Component("jwtTokenService")
public class JwtTokenServiceImpl implements TokenService {
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";

    @Override
    public String createToken(String username) {
        String token;
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("now", System.currentTimeMillis())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    @Override
    public boolean verifyToken(String username, String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
