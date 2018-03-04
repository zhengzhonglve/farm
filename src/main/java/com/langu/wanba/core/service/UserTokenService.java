package com.langu.wanba.core.service;

import com.langu.wanba.core.result.Result;

/**
 * Created by Ben on 16/8/30.
 */
public interface UserTokenService {

    /**
     * 更新或新增用户token
     *
     * @param userId 用户id
     * @param token  token字符串
     * @return
     */
    Result<Void> upsetUserToken(long userId, String token);

    /**
     * 根据用户id获取token
     *
     * @param userId
     * @return
     */
    Result<String> getTokenByUserId(long userId);

    /**
     * 删除用户的token
     *
     * @param userId
     * @return
     */
    Result<Void> deleteTokenByUserId(long userId);

}
