package com.langu.wanba.core.service;

import com.langu.wanba.core.common.user.User;
import com.langu.wanba.core.data.domain.UserDo;
import com.langu.wanba.core.result.Result;

/**
 * User服务
 * Created by Ben on 16/8/29.
 */
public interface UserService {


    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    Result<User> getUserById(long userId);


}
