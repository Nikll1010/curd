/**
 * @program: demo
 * @description: Controller
 * @author Nikll
 * @date 2019/2/16 21:45
 */
package com.nikll.demo.controller;

import com.nikll.demo.db.MyUser;
import com.nikll.demo.service.MyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Nikll

 * @date 2019/2/16 21:45

 */
@Slf4j
@Controller
@RequestMapping
@Api(value = "/",description = "这是我的全部请求")
public class MyController {
    @Autowired
    MyUserService myUserService;
    @RequestMapping("/aaa")
    @ApiOperation(value = "登陆系统")
    public String index(Model model){
        log.info("登陆");
        String name = "MyControl登陆系统";
        String total = String.valueOf(myUserService.getTotal());
        model.addAttribute("name",name);
        model.addAttribute("total",total);
        return "index";
    }
    @RequestMapping("/index")
    public String login(HttpServletRequest request,HttpServletResponse resopnse){
        log.info("开始添加"+this.getClass());
        MyUser myUser = new MyUser();
        int user = Integer.parseInt(request.getParameter("user_id"));
        String password = request.getParameter("password");
        String requeturl = request.getRequestURL().toString();
        myUser.setUser_id(user);
        myUser.setPassword(password);
        myUserService.addUser(myUser);
//        int tot = myUserService.getTotal();
        String total = String.valueOf(myUserService.getTotal());
        Model model =new ExtendedModelMap();
        model.addAttribute("total",total);
        log.info("总数是"+total);
        return "index";
    }

}