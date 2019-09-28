package com.mongo.controller;

import com.mongo.entity.UserInfo;
import com.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Classname UserController
 * Description TODO
 * Date 2019/8/13 19:54
 * Created by Administrator
 */

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"},value = {"/user"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/getUser"}, method = {RequestMethod.GET})
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        userRepository.save(userInfo);
        return "success";
    }


    @GetMapping("getUserList")
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfoList = userRepository.findAll();
        return userInfoList;
    }

    @GetMapping("delete")
    public String delete(Long id){
        userRepository.delete(id);
        return "success";
    }

    @GetMapping("update")
    public String update(Long id,String username,String password){
        UserInfo userInfo = new UserInfo(id,username,password);
        userRepository.save(userInfo);
        return "success";
    }

}
