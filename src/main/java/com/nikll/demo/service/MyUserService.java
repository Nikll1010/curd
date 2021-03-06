/**
 * @program: demo
 * @description: MyUserService
 * @author Nikll
 * @date 2019/2/17 0:13
 */
package com.nikll.demo.service;

import com.nikll.demo.db.MyUser;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/2/17 0:13

 */
public interface MyUserService {
    int getTotal();
    void addUser(MyUser myUser);
    void deleteUser(int id);
    void updateUser(MyUser myUser);
    MyUser getUser(int id);
    List<MyUser> getUsers(MyUser user);
    List<MyUser> getUserlist(int start, int end);
}