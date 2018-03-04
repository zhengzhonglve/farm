package com.langu.wanba.web.token;

import com.langu.authorization.exception.UserInvalidException;
import com.langu.authorization.service.TokenUserService;
import com.langu.wanba.core.manager.TokenManager;
import com.langu.wanba.core.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 校验token是否匹配
 * Created by Ben on 16/9/6.
 */
public class DefaultTokenUserService implements TokenUserService {

    private final static Logger log = LoggerFactory.getLogger(DefaultTokenUserService.class);

    @Resource
    private TokenManager tokenManager;

    @Override
    public boolean isUserIdMatchToken(String token, long userId) throws UserInvalidException {
        Result<String> checkRes = tokenManager.getUserToken(userId);
        if (checkRes.isSuccess()) {
            return StringUtils.equals(token, checkRes.getObject());
        } else {
            log.error("getUserToken failed. userId:{} token:{}", userId, token);
        }
        return false;
    }
}
