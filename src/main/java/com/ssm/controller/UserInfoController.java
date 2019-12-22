package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ssm.common.BackMsg;
import com.ssm.domain.UserInfo;
import com.ssm.service.RoleService;
import com.ssm.service.UserInfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoservice userInfoservice;
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/getUserName.do",method = RequestMethod.GET)
    @ResponseBody
    public String  getUserName(String username){
        BackMsg backMsg = new BackMsg();
        boolean b=userInfoservice.getUserName(username);
        if (b){
            backMsg.setStatus(1);
        }else {
            backMsg.setStatus(0);
        }
        return JSON.toJSONString(backMsg);
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public String  register(UserInfo userInfo){
        System.out.println(userInfo);
        BackMsg backMsg=userInfoservice.register(userInfo);
        return JSON.toJSONString(backMsg);
    }

    @RequestMapping(value = "/getPosition.do",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getPosition(HttpServletResponse response){
        List<String> list=roleService.getPosition();
        String s = JSON.toJSONString(list);
        return s;
    }

    @RequestMapping(value = "/login.do",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String  login(String name, String pass, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        BackMsg backMsg = new BackMsg();
        UserInfo userInfo=userInfoservice.login(name,pass);
        if (userInfo!=null){
            backMsg.setStatus(1);
            session.setAttribute("userInfo",userInfo);
        }else {
            backMsg.setStatus(0);
            backMsg.setMsg("用户名或密码不对");
        }
        return JSON.toJSONString(backMsg);
    }

    @RequestMapping(value = "/getStatus.do",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getStatus(){
        List<UserInfo> userInfos=userInfoservice.getStatus();
        return JSON.toJSONString(userInfos);
    }

    @RequestMapping(value = "/setStatus.do",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String setStatus(String id ,String position,String status){
//        return JSON.toJSONString();
        System.out.println(id);
        System.out.println(position);
        System.out.println(status);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("status",1);
        return JSON.toJSONString(objectObjectHashMap);
    }

}
