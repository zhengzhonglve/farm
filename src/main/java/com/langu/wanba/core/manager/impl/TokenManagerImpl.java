package com.langu.wanba.core.manager.impl;

import com.langu.authorization.token.BlowfishToken;
import com.langu.wanba.core.manager.TokenManager;
import com.langu.wanba.core.result.Result;
import com.langu.wanba.core.result.error.ErrorCode;
import com.langu.wanba.core.service.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TokenManagerImpl implements TokenManager {

    private final static Logger log = LoggerFactory.getLogger(TokenManagerImpl.class);

    private final static String DEFAULT_CLIENT = "app";

    @Resource
    private UserTokenService userTokenService;

    @Override
    public Result<String> generateToken(long userId, boolean save) {
        Result<String> result = Result.newResult();
        BlowfishToken token = new BlowfishToken();
        token.setUserId(userId);
        token.setClient(DEFAULT_CLIENT);
        token.setTokenTime(System.currentTimeMillis());
        try {
            String str = token.generate();
            if (save) {
                Result<Void> saveRes = userTokenService.upsetUserToken(userId,str);
                if (!saveRes.isSuccess()){
                    result.addErrors(saveRes.getErrors());
                }
            }
            result.setObject(str);
        } catch (Exception e) {
            result.addError(ErrorCode.TOKEN_GENERATE_FAILED);
            log.error("generate token exception", e);
        }
        return result;
    }

    @Override
    public Result<Void> removeToken(long userId) {
        return userTokenService.deleteTokenByUserId(userId);
    }

    @Override
    public Result<String> getUserToken(long userId) {
        return userTokenService.getTokenByUserId(userId);
    }
}
