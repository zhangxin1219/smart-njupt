package com.github.njupt.zuul.token;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 12:15
 * @Description:
 */
public interface TokenService {
    String createToken(String username);

    boolean verifyToken(String username, String token);

    String getUsername(String token);
}
