package com.shrio.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 14:42
 * @Description:
 */

public class ShiroConfiguration {


    @Bean("shiroFilter")
     public ShiroFilterFactoryBean shiroFilter(@Autowired SecurityManager manager){
        ShiroFilterFactoryBean factoryBean =new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauthrized");  //无权限访问的url

        HashMap<String,String> filterChainDefinitionMap =new LinkedHashMap<>();

        filterChainDefinitionMap.put("/index", "authc");
        filterChainDefinitionMap.put("/login","anon");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return factoryBean;

    }


    @Bean("securityManager")
    public SecurityManager securityManager(@Autowired AuthRealm authRealm){
        DefaultWebSecurityManager manager =new DefaultWebSecurityManager();
        manager.setRealm(authRealm);

        return manager;


    }


    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {


        return new CredentialMatcher();
    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher credentialMatcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(credentialMatcher);
        return authRealm;


    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor =new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);

    return advisor;

    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator =new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;


    }
}
