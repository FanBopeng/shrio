package com.shrio;

import com.shrio.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fanbopeng
 * @Date: 2019/3/29 15:36
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private Userservice userservice;


    @RequestMapping("/login")
    public String login(){

        return "index";
    }


}
