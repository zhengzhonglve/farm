package com.hades.farm.core.manager;

import com.hades.farm.core.common.user.User;
import com.hades.farm.core.result.Result;

/**
 * Created by Ben on 16/9/5.
 */
public interface UserCacheManager {

    /**
     * 缓存用户
     * @return
     */
    Result<Void> cacheUser(User user);

    /**
     * 获取缓存的用户
     * @param userId
     * @return
     */
    Result<User> getCacheUser(long userId);

    /**
     * 删除缓存用户
     * @param userId
     * @return
     */
    Result<Void> removeCacheUser(long userId);
}
