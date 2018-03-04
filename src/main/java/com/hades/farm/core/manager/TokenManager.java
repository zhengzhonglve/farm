package com.hades.farm.core.manager;

import com.hades.farm.core.result.Result;

/**
 * Token获取和删除
 * Created by Ben on 16/9/5.
 */
public interface TokenManager {

    /**
     * 获取token
     * @param userId 用户ID
     * @param save 是否存储
     * @return
     */
    Result<String> generateToken(long userId, boolean save);

    /**
     * 删除用户token
     * @param userId
     * @return
     */
    Result<Void> removeToken(long userId);

    /**
     * 获取用户token
     * @param userId
     * @return
     */
    Result<String> getUserToken(long userId);

}
