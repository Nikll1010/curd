/**
 * @program: demo
 * @description: user表
 * @author Nikll
 * @date 2019/2/16 23:55
 */
package com.nikll.demo.db;

import lombok.Data;

/**
 * @author Nikll

 * @date 2019/2/16 23:55

 */
@Data
public class MyUser {
    private int id;
    private int user_id;
    private String password;
}