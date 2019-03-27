/**
 * @program: demo
 * @description: MyUserServiceImpl
 * @author Nikll
 * @date 2019/2/17 0:15
 */
package com.nikll.demo.serviceImpl;

import com.nikll.demo.db.MyUser;
import com.nikll.demo.mapper.MyUserDao;
import com.nikll.demo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nikll

 * @date 2019/2/17 0:15

 */
@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    MyUserDao myUserDao;
    public int getTotal(){
        return myUserDao.getTotal();
    };
    public void addUser(MyUser myUser){
        myUserDao.addUser(myUser);
    };
    public void deleteUser(int id){
        myUserDao.deleteUser(id);
    };
    public void updateUser(MyUser myUser){
        myUserDao.updateUser(myUser);
    };
    public MyUser getUser(int id){
       return myUserDao.getUser(id);
    };
}