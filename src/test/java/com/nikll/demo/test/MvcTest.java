/**
 * @program: demo
 * @description: MvcTest
 * @author Nikll
 * @date 2019/4/16 16:23
 */
package com.nikll.demo.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikll

 * @date 2019/4/16 16:23

 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MvcTest {

    MockMvc mvc;

    @Autowired
    WebApplicationContext context;



    @Before
    public void initMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
//        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        linkedMultiValueMap.add("user_id","1000");
        linkedMultiValueMap.add("password","1000");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/index").params(linkedMultiValueMap)).andReturn();
        MockHttpServletRequest resultRequest = result.getRequest();
//        System.out.println(resultRequest.getAttribute("name"));
        resultRequest.getAttribute("total");
        System.out.println(resultRequest.getAttribute("total"));
    }
    @Test
    public void testPages() throws Exception {
//        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        linkedMultiValueMap.add("user_id","1000");
        linkedMultiValueMap.add("password","1000");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/aaa")).andReturn();
        MockHttpServletRequest resultRequest = result.getRequest();
        System.out.println(resultRequest.getAttribute("name"));
        resultRequest.getAttribute("total");
        System.out.println(resultRequest.getAttribute("total"));
    }
    @Test
    public void testdemo(){
//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        System.out.println(input);
        List<Integer> n = new ArrayList<>();
        n.add(1);
        n.add(1);
        System.out.println(n);
//        1,1,2,3,5,8,13
        for (int i=2;i<12;i++){
            n.add(n.get(i-2)+n.get(i-1));
            System.out.println(n.get(i).hashCode());
            System.out.println(n);
        }
        System.out.println(n.get(8));
    }
/*
    @Test
    public void preorderRecursion(TreeNode root){
        doSoming(root);
        if (root.children()!= null)
            preorderRecursion((TreeNode) root.children());
        (x,y) -> Integer.compare(x.getAge(),y.getAge();
    }

    private void doSoming(TreeNode root) {
        System.out.println(root.children());
    }
*/

}