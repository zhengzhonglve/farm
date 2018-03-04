package com.hades.farm.core.data.domain;

import com.hades.farm.enums.RegistMode;
import com.hades.farm.enums.UserState;

import java.util.Date;

/**
 * 用户模型
 * Created by Ben on 16/8/29.
 */
public class UserDo {

    /**
     * 用户Id,自增
     */
    private long userId;
    /**
     * 默认昵称组成部分
     */
    private String part;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 用户头像
     */
    private String face;
    /**
     * 手机区号
     */
    private int ccode = 86;
    /**
     * 手机号码
     */
    private String phone = "";
    /**
     * 用于给密码加密的加密字符串
     */
    private String solt;
    /**
     * 用户密码, 采用MD5(solt+input)
     */
    private String passwd;
    /**
     * qq号登陆
     */
    private String qq = "";
    /**
     * 微信登陆
     */
    private String wechat = "";
    /**
     * 注册类型 {@link RegistMode}
     */
    private byte regMode;
    /**
     * IM账号
     */
    private String chatId;
    /**
     * IM密码
     */
    private String chatPwd;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 用户状态 {@link UserState}
     */
    private byte state;
    /**
     *
     * 客户端IP地址
     */
    private String ip;
    /**
     * 同步数据版本号,更新用户信息需要更新版本号
     */
    private int syncVersion;
    /**
     * 最后登录时间
     */
    private Date lastLogin;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 渠道
     */
    private String channel;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getCcode() {
        return ccode;
    }

    public void setCcode(int ccode) {
        this.ccode = ccode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public byte getRegMode() {
        return regMode;
    }

    public void setRegMode(byte regMode) {
        this.regMode = regMode;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getChatPwd() {
        return chatPwd;
    }

    public void setChatPwd(String chatPwd) {
        this.chatPwd = chatPwd;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getSyncVersion() {
        return syncVersion;
    }

    public void setSyncVersion(int syncVersion) {
        this.syncVersion = syncVersion;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
