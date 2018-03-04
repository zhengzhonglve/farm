package com.hades.farm.core.data.mapper;

import com.hades.farm.core.data.domain.UserDo;

/**
 * 用户DAO
 * Created by Ben on 16/8/30.
 */
public interface UserMapper {

    /**
     * 根据ID获取用户
     * @param userId
     * @return
     */
    UserDo getUserById(long userId);


}
