package com.shrio.service;

import com.shrio.mapper.UserMapper;
import com.shrio.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 13:14
 * @Description:
 */
@Service
public class UserserviceImpl implements Userservice {

    @Resource
    private UserMapper userMapper;


    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByName(username);
    }
}
