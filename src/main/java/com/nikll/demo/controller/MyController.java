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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nikll
 * @date 2019/2/16 21:45
 */
@Slf4j
@RestController
@RequestMapping
@Api(value = "/", description = "这是我的全部请求")
public class MyController {
    @Autowired
    MyUserService myUserService;

    //获取系统名称
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "登陆系统", httpMethod = "GET")
    public String index(Model model) {
        log.info("登陆");
        String name = "MyControl登陆系统";
        String total = String.valueOf(myUserService.getTotal());
        model.addAttribute("name", name);
        model.addAttribute("total", total);
        return "index";
    }

    //查询分页数据
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ApiOperation(value = "查询分页数据", httpMethod = "GET")
    public List<MyUser> getUserList(@RequestParam int start, @RequestParam int end) {
        List<MyUser> myUserList = myUserService.getUserlist(start, end);
        return myUserList;
    }

    //查询单条数据
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条数据", httpMethod = "GET")
    public MyUser getUser(@RequestParam int id) {
        return myUserService.getUser(id);
    }

    //更新单条数据
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更新单条数据", httpMethod = "POST")
    public void updateUser(@RequestParam int id, @RequestBody MyUser user) {
        MyUser myUser = new MyUser();
        myUser.setId(id);
        myUser.setUser_id(user.getUser_id());
        myUser.setPassword(user.getPassword());
        myUserService.updateUser(myUser);
    }

    //新增数据
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增数据", httpMethod = "POST")
    public void addUser(@RequestBody MyUser user) {
        myUserService.addUser(user);
    }

    //删除数据
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    @ApiOperation(value = "删除数据", httpMethod = "GET")
    public void delUser(@RequestParam int id) {
        myUserService.deleteUser(id);
    }

}