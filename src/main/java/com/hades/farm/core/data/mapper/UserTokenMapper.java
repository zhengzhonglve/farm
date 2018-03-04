package com.hades.farm.core.data.mapper;

import com.hades.farm.core.data.domain.UserTokenDo;
import org.apache.ibatis.annotations.Param;

/**
 *  用户token DAO
 * Created by Ben on 16/9/2.
 */
public interface UserTokenMapper {
    /**
     * 插入用户token
     * @param userTokenDo
     * @return
     */
    int insertUserToken(UserTokenDo userTokenDo);

    /**
     * 根据用户Id获取token
     * @param userId
     * @return
     */
    UserTokenDo getUserTokenById(long userId);

    /**
     * 更新用户token
     * @param userId
     * @param token
     * @return
     */
    int updateUserToken(@Param("userId") long userId, @Param("token") String token);

    /**
     * 删除用户token
     * @param userId
     * @return
     */
    int deleteUserToken(long userId);

}
