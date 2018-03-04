package com.hades.farm.enums;

import com.hades.farm.core.data.domain.UserDo;
import org.apache.commons.lang3.StringUtils;

/**
 * 用户注册类型
 * Created by Ben on 16/9/1.
 */
public enum RegistMode {

    UNDEFINED((byte) 0, "未定义"),
    PHONE((byte) 1, "手机用户"),
    WEIXIN((byte) 2, "微信用户"),
    QQ((byte) 3, "QQ用户");

    private byte regMode;

    private String desc;

    private String key;

    RegistMode(byte regMode, String desc) {
        this.regMode = regMode;
        this.desc = desc;
    }

    public static RegistMode getMode(byte regMode) {
        RegistMode[] values = RegistMode.values();
        for (RegistMode value : values) {
            if (value.getRegMode() == regMode) {
                return value;
            }
        }
        return UNDEFINED;
    }

    public static RegistMode getRegMode(UserDo user) {
        if (user == null) {
            return UNDEFINED;
        }
        if (StringUtils.isNoneBlank(user.getPhone())) {
            PHONE.key = user.getPhone();
            return PHONE;
        }
        if (StringUtils.isNoneBlank(user.getQq())) {
            PHONE.key = user.getQq();
            return QQ;
        }
        if (StringUtils.isNoneBlank(user.getWechat())) {
            PHONE.key = user.getWechat();
            return WEIXIN;
        }
        return UNDEFINED;
    }

    public byte getRegMode() {
        return regMode;
    }

    public String getDesc() {
        return desc;
    }

    public String getKey() {
        return key;
    }
}
