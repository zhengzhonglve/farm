package com.langu.wanba.core.common.user;

import com.langu.wanba.enums.RegistMode;
import com.langu.wanba.enums.UserState;

import java.io.Serializable;

/**
 * Created by Ben on 16/9/5.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 4458098481442553998L;
    /**
     * 用户Id,自增
     */
    private long userId;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 默认昵称
     */
    private String part;
    /**
     * 用户头像
     */
    private String face;
    /**
     * 用户状态 {@link UserState}
     */
    private byte state;
    /**
     * 手机区号
     */
    private int ccode = 86;
    /**
     * 注册类型 {@link RegistMode}
     */
    private byte regMode;
    /**
     * 手机号码
     */
    private String phone = "";
    /**
     * qq号登陆
     */
    private String qq = "";
    /**
     * 微信登陆
     */
    private String wechat = "";
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
     *
     * 客户端IP地址
     */
    private String ip;
    /**
     * 同步数据版本号,更新用户信息需要更新版本号
     */
    private int syncVersion;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public int getSyncVersion() {
        return syncVersion;
    }

    public void setSyncVersion(int syncVersion) {
        this.syncVersion = syncVersion;
    }

    public byte getRegMode() {
        return regMode;
    }

    public void setRegMode(byte regMode) {
        this.regMode = regMode;
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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
