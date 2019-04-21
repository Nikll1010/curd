package com.nikll.demo.test;


import com.nikll.demo.db.MyUser;
import com.nikll.demo.mapper.MyUserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;


/**
 * @author Nikll
 * @date 2019/4/15 22:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyUserDaoTest {
    @Autowired
    MyUserDao myUserDao;
    @Autowired
    SqlSession sqlSession;
    @Before
    public void init(){
        System.out.println("-------初始化-------");
    }
    @After
    public void testEnd(){
        System.out.println("-------测试结束-------");
    }
    /**
     * 多行注释
     */
    @Test
    public void testCRUD(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("application.properties");
//        MyUserServiceImpl myUserServiceimpl = new MyUserServiceImpl();
//        myUserServiceimpl.getTotal();
      /*  System.out.println(myUserDao);
        try {
            myUserDao.getTotal();
            System.out.println(myUserDao.getTotal());
        }catch (NullPointerException e){
            e.printStackTrace();
        }*/


//        myUserDao.addUser(new MyUser(5,"12345321"));
        System.out.println(myUserDao.getUser(15).getUser_id());
        System.out.println(myUserDao.getUser(15).getPassword());

    }

    @Test
    public void testCread(){
//        String uuid = UUID.randomUUID().toString().substring(0,5);
        MyUserDao myUserDao = sqlSession.getMapper(MyUserDao.class);
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().substring(0,7);
            myUserDao.addUser(new MyUser(i,uuid));
        }
    }
    @Test
    public void testDelete(){
        for (int i = 0; i < 100; i++) {
            myUserDao.deleteUser(i+100);
        }
    }
    @Test
    public void testGetTotal(){
        myUserDao.getTotal();
        System.out.println(myUserDao.getTotal());
    }
}