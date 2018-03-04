package com.langu.wanba.core.service.impl;

import com.langu.wanba.core.common.user.User;
import com.langu.wanba.core.data.domain.UserDo;
import com.langu.wanba.core.data.mapper.UserMapper;
import com.langu.wanba.core.manager.UserCacheManager;
import com.langu.wanba.core.result.Result;
import com.langu.wanba.core.result.error.ErrorCode;
import com.langu.wanba.core.service.UserService;
import com.langu.wanba.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ben on 16/8/29.
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Resource
    private UserMapper userMapper;

    @Resource
    private UserCacheManager userCacheManager;

    @Override
    public Result<User> getUserById(long userId) {
        Result<User> result = userCacheManager.getCacheUser(userId);
        if (result.isSuccess() && result.getObject() != null) {
            return result;
        }
        UserDo userDo = userMapper.getUserById(userId);
        if (userDo == null) {
            result.addError(ErrorCode.USER_NOT_EXIST);
            return result;
        }
        User user = BeanUtil.copyBean(userDo, User.class);
        Result<Void> cacheRes = userCacheManager.cacheUser(user);
        if (!cacheRes.isSuccess()) {
            log.warn("cache user failed, userId:{} errorMsg:{}", userId, cacheRes.getErrMsg());
        }
        result.setObject(user);
        return result;
    }
}
