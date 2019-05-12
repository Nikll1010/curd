/**
 * @program: demo
 * @description: userdao
 * @author Nikll
 * @date 2019/2/16 23:58
 */
package com.nikll.demo.mapper;

import com.nikll.demo.db.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Nikll

 * @date 2019/2/16 23:58

 */
@Mapper
public interface MyUserDao {
    int getTotal();
    void addUser(MyUser myUser);
    void deleteUser(int id);
    void updateUser(MyUser myUser);
    MyUser getUser(int id);
    List<MyUser> getUsers(MyUser user);
    List<MyUser> getUserlist(int start, int end);
}