package com.github.njupt.campus.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/10/11 10:27
 * @Description:
 */
public class Md5Utils {
    public static String randomSalt() {
        String str = "abcdef" + "0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(str.length());
            stringBuffer.append(str.charAt(index));
        }
        return stringBuffer.toString();
    }

    public static String md5DigestAsHex(String plaintext) {
        return DigestUtils.md5DigestAsHex(plaintext.getBytes());
    }

    public static String md5DigestAsHex(String plainText, String salt) {
        return DigestUtils.md5DigestAsHex((plainText + salt).getBytes());
    }
}
