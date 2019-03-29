package com.shrio.mapper;

import com.shrio.modle.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 13:11
 * @Description:
 */
public interface UserMapper {

    User findUserByName(@Param("username") String username);
}
