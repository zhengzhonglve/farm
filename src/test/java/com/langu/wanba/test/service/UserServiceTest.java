package com.langu.wanba.test.service;

import com.langu.wanba.core.common.user.User;
import com.langu.wanba.core.result.Result;
import com.langu.wanba.core.service.UserService;
import com.langu.wanba.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiaoxu on 2016/11/9.
 */
public class UserServiceTest extends BaseTest {
    @Resource
    private UserService userService;

    @Test
    public void test(){
        Result<User> result= userService.getUserById(1);
        if(result.isSuccess()){
            User obj = result.getObject();
            System.out.println("名称:"+obj.getNick());
        }
    }
}
