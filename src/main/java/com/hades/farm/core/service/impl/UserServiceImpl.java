package com.hades.farm.core.service.impl;

import com.hades.farm.core.data.entity.User;
import com.hades.farm.core.result.Result;
import com.hades.farm.core.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by xiaoxu on 2018/3/4.
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public Result<User> get(long userId) {
        Result<User> result = Result.newResult();

        return result;
    }
}
