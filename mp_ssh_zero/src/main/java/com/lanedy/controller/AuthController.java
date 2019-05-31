package com.lanedy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liyue
 * Time 2019-03-26 15:40
 */
@Controller
public class AuthController {

    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping("/login")
    public String forwardToLogin(){
        return "login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login.do")
    public String login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            SecurityUtils.getSubject().login(token);
            return "home"; // 登录身份验证成功，跳转到个人页 home.jsp
        } catch (AuthenticationException ace){
            ace.printStackTrace();
        }
        return "login"; // 登录认证失败，返回 login.jsp 页面要求继续认证
    }

    /**
     * 退出登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        // 当前用户是否为登录状态，已登录状态则登出
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "login"; // 退出登录，并返回到登录页面
    }
}
