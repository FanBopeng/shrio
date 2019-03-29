package com.shrio.service;

import com.shrio.modle.User;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 13:13
 * @Description:
 */
public interface Userservice {

    User findUserByUsername(String username);

}
