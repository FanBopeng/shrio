package com.shrio.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 14:36
 * @Description:密码校验规则
 */

public class CredentialMatcher extends SimpleCredentialsMatcher {


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
      UsernamePasswordToken usernamePasswordToken =  (UsernamePasswordToken)token;
        char[] passwordChar = usernamePasswordToken.getPassword();
        String password = passwordChar.toString();
        String  dbPassword =(String) info.getCredentials();

        return this.equals(password,dbPassword);

    }
}
