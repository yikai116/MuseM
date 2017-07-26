package DTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Jaho on 2017/5/9.
 * 生成Token以及作为登录注册返回结果的Response:data
 */

@CrossOrigin
@RestController
public class Token {

    private String email;
    private String token;

    private static String getATokenStr(){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        String token;

        for (int i = 0; i < 16; i++) {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }

            token = sb.toString();

        return token;
    }

    public Token(){
        this.email = "";
        this.token = getATokenStr();
    }

    public Token(String email){
        this.email = email;
        this.token = getATokenStr();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokenStr() {
        return token;
    }

    public void setTokenStr(String token) {
        this.token = token;
    }

}