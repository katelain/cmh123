package com.iweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iweb.entity.User;
import com.iweb.service.UserInfoService;
import com.iweb.service.UserService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * LoginCOntroller
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 15:45
 */
//@Controller
    @RestController
public class userInfoController {
        Logger logger = Logger.getLogger(userInfoController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;



    @RequestMapping("/userLogin")
    //@ResponseBody
    public String loginControl(@RequestParam Map map, HttpSession httpSession, HttpServletRequest request) {
        logger.debug("锁定时间："+request.getServletContext().getAttribute("locktime"));
        httpSession.setAttribute("username",map.get("username"));
        String captcha=(String) map.get("captcha");
        String session_yzm = (String)httpSession.getAttribute("code");
        long logintime = System.currentTimeMillis() / 1000;
        map.put("logintime",logintime);
        long locktime=(Long) request.getServletContext().getAttribute("locktime");
        map.put("locktime",locktime);

        //统一大小写
        if (captcha.equals(session_yzm)) {
            try {
                User user=new User();
                if(logintime-locktime<user.getLogintime().getTime()*60 &&user.getFailcount()>=3){
                    //三次机会用光
                    return "chanceOut";
                }
                int count =userService.login(map);
                //未查找到数据
                if(count==0){
                    userService.login(map);
                    return "fail";
                }else {
                    //查到数据

                    return "success";
                }
            } catch (Exception e) {
                return "err";
            }
        }else {
            return "codeErr";

        }
    }

    @RequestMapping("/showAllUserInfo")
    //@ResponseBody
    public Map showAllUserInfo(){
        ObjectMapper om =new ObjectMapper();

        Map<String,Object> userinfos = new HashMap<>();

        try{
            userinfos.put("code",0);
            userinfos.put("msg","success");
            userinfos.put("count",userInfoService.showAll().size());
            userinfos.put("data",userInfoService.showAll());
            //System.out.println(userinfos);

            return userinfos;

        }catch (Exception e){
            e.printStackTrace();
            userinfos.put("code",-1);
            userinfos.put("msg","fail");
            return userinfos;

        }

    }


    @RequestMapping("/deleteManyUserInfos")
    //@ResponseBody
    public String deleteManyUserInfos(String[] ids) throws ServletException, IOException {
        System.out.println("userid=="+ids);
        JSONArray jsonArray=new JSONArray(ids);
        String[] idss = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            ids[i]=jsonArray.getString(i);
        }
        try {
            boolean flag =  userInfoService.delUserInfoMany(idss);
            if (flag) {
                return "success";
            }else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "err";
        }

    }

    @RequestMapping("/insertManyUserInfo")
    //@ResponseBody
    public String insertManyUserInfos(@RequestParam Map map) throws ServletException, IOException {

        Map<String,Object> userinfos = new HashMap<>();
        try {
            boolean flag=  userInfoService.addUserInfo(map);
            System.out.println(flag);
            if(!flag){
                return "success";
            }else{
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "500";
        }
    }


}
