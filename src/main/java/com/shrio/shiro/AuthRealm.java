package com.shrio.shiro;

import com.shrio.modle.Permission;
import com.shrio.modle.Role;
import com.shrio.modle.User;
import com.shrio.service.Userservice;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 14:10
 * @Description:授权类
 */
@Component
public class AuthRealm extends AuthorizingRealm {


    @Autowired
    private Userservice userservice;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator();
        List<String> permissionList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if (!CollectionUtils.isEmpty(roleSet)) {
            roleSet.stream().forEach((role) -> {
                role.getPermissions().stream().forEach(permission -> {
                    permissionList.add(permission.getName());

                });
            });

        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);

        return null;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userservice.findUserByUsername(username);


        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
