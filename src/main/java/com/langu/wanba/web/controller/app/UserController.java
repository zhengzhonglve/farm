package com.langu.wanba.web.controller.app;

import com.langu.authorization.annotation.Auth;
import com.langu.wanba.core.common.user.User;
import com.langu.wanba.core.result.Result;
import com.langu.wanba.core.service.UserService;
import com.langu.wanba.web.model.ViewResult;
import com.langu.wanba.web.model.view.user.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiaoxu on 2016/11/9.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/getUserById", method = RequestMethod.POST)
//    @Auth
    public ViewResult getUserById(@RequestParam long userId) {
        ViewResult<UserModel> result = new ViewResult<>();
        Result<User> uRes = userService.getUserById(userId);
        if (!uRes.isSuccess()) {
            result.addError(uRes.getErrMsg());
            return result;
        }
        return result;
    }
}
