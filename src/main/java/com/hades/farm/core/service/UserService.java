package com.hades.farm.core.service;

import com.hades.farm.core.common.user.User;
import com.hades.farm.core.result.Result;

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
