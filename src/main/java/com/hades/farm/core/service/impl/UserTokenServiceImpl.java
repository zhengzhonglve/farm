package com.hades.farm.core.service.impl;

import com.hades.farm.core.data.domain.UserTokenDo;
import com.hades.farm.core.data.mapper.UserTokenMapper;
import com.hades.farm.core.service.UserTokenService;
import com.hades.farm.core.result.Result;
import com.hades.farm.core.result.error.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ben on 16/8/30.
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    private final static Logger log = LoggerFactory.getLogger(UserTokenServiceImpl.class);

    /**
     * token缓存前缀
     */
    private final static String USER_TOKEN_PRE = "ut_";

    /**
     * 用户token的缓存超时时间 2hours
     */
    private final static int TOKEN_CACHE_EXPIRED = 60 * 60 * 2;

    @Resource
    private UserTokenMapper userTokenMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void test() {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
//                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
//                for (Map<String, Object> map : list) {
//                    byte[] key  = serializer.serialize(tableName+":"+map.get("hcode").toString());
//                    byte[] name = serializer.serialize(map.get("pcode").toString());
//                    connection.setNX(key, name);
//                    connection.sPop(new byte[]{'3','a'});
//                }
                return true;
            }
        }, false, true);
    }

    @Override
    public Result<Void> upsetUserToken(long userId, String token) {
        Result<Void> result = Result.newResult();
        if (userId < 1) {
            result.addError(ErrorCode.USER_ID_INVALID);
            return result;
        }
        if (StringUtils.isBlank(token)) {
            result.addError(ErrorCode.ARG_NOT_NULL);
            return result;
        }
        Result<String> tokenRes = getTokenByUserId(userId);
        if (!tokenRes.isSuccess()) {
            result.addErrors(tokenRes.getErrors());
            return result;
        }
        String dbToken = tokenRes.getObject();
        if (StringUtils.isNoneBlank(dbToken)) {
            if (!StringUtils.equals(dbToken, token)) {
                int res = userTokenMapper.updateUserToken(userId, token);
                if (res == 0) {
                    result.addError(ErrorCode.TOKEN_UPDATE_FAILED);
                } else {
                    redisTemplate.boundValueOps(USER_TOKEN_PRE + userId).expire(0L, TimeUnit.MILLISECONDS);
                }
            }
        } else {
            UserTokenDo userTokenDo = new UserTokenDo();
            userTokenDo.setToken(token);
            userTokenDo.setUserId(userId);
            int res = userTokenMapper.insertUserToken(userTokenDo);
            if (res == 0) {
                result.addError(ErrorCode.TOKEN_INSERT_FAILED);
            }
        }
        return result;
    }

    @Override
    public Result<String> getTokenByUserId(long userId) {
        Result<String> result = Result.newResult();
        if (userId < 1) {
            result.addError(ErrorCode.USER_ID_INVALID);
            return result;
        }
        Object token = redisTemplate.boundValueOps(USER_TOKEN_PRE + userId).get();
        if (token == null) {
            UserTokenDo userTokenDo = userTokenMapper.getUserTokenById(userId);
            if (userTokenDo != null) {
                result.setObject(userTokenDo.getToken());
                redisTemplate.boundValueOps(USER_TOKEN_PRE + userId).set(userTokenDo.getToken(), TOKEN_CACHE_EXPIRED, TimeUnit.SECONDS);
            }
        } else {
            result.setObject(String.valueOf(token));
        }
        return result;
    }

    @Override
    public Result<Void> deleteTokenByUserId(long userId) {
        Result<Void> result = Result.newResult();
        Result<String> tokenRes = getTokenByUserId(userId);
        if (tokenRes.isSuccess()) {
            String token = tokenRes.getObject();
            if (StringUtils.isNoneBlank(token)) {
                int res = userTokenMapper.deleteUserToken(userId);
                if (res == 0) {
                    result.addError(ErrorCode.TOKEN_DELETE_FAILED);
                } else {
                    redisTemplate.boundValueOps(USER_TOKEN_PRE + userId).expire(0l, TimeUnit.MILLISECONDS);
                }
            }
        } else {
            result.addErrors(tokenRes.getErrors());
        }
        return result;
    }
}
