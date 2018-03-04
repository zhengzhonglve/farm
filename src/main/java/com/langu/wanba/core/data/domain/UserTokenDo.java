package com.langu.wanba.core.data.domain;

import java.util.Date;

/**
 * 用户token表
 * Created by Ben on 16/9/2.
 */
public class UserTokenDo {

    /**
     * 用户id
     */
    private long userId;
    /**
     * token字符串
     */
    private String token;
    /**
     * token生成时间
     */
    private Date updateTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
