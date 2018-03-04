package com.hades.farm.core.manager.impl;

import com.hades.farm.core.common.user.User;
import com.hades.farm.core.manager.UserCacheManager;
import com.hades.farm.core.result.Result;
import com.hades.farm.core.result.error.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ben on 16/9/5.
 */
@Component
public class UserCacheManagerImpl implements UserCacheManager {

    private final static Logger log = LoggerFactory.getLogger(UserCacheManagerImpl.class);

    private final static String USER_CAHCE_PRE = "yg_user_";

    private final static int USER_CACHE_TIME = 60 * 12;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Result<Void> cacheUser(User user) {
        Result<Void> result = Result.newResult();
        try {
            BoundValueOperations<String, Object> bvp = redisTemplate.boundValueOps(USER_CAHCE_PRE + user.getUserId());
            bvp.set(user, USER_CACHE_TIME, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error("cache user exception", e);
            result.addError(ErrorCode.SYSTEM_ERROR);
        }
        return result;
    }

    @Override
    public Result<User> getCacheUser(long userId) {
        Result<User> result = Result.newResult();
        try {
            BoundValueOperations<String, Object> bvp = redisTemplate.boundValueOps(USER_CAHCE_PRE + userId);
            Object user = bvp.get();
            if (user != null){
                result.setObject((User) user);
            }
        } catch (Exception e) {
            log.error("getCacheUser exception", e);
            result.addError(ErrorCode.SYSTEM_ERROR);
        }
        return result;
    }

    @Override
    public Result<Void> removeCacheUser(long userId) {
        Result<Void> result = Result.newResult();
        try {
            redisTemplate.delete(USER_CAHCE_PRE + userId);
        } catch (Exception e) {
            log.error("remove cache user exception", e);
            result.addError(ErrorCode.SYSTEM_ERROR);
        }
        return result;
    }
}
