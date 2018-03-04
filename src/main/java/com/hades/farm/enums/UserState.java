package com.hades.farm.enums;

/**
 * Created by Ben on 16/9/1.
 */
public enum UserState {

    UNDEFINED((byte)0,"未定义"),
    NORAL((byte)1,"正常"),
    BLOCK((byte)1,"封号"),
    ;

    private byte state;
    private String desc;

    UserState(byte state,String desc){
        this.state = state;
        this.desc = desc;
    }

    public static UserState getState(byte state){
        UserState[] values = UserState.values();
        for (UserState value : values) {
            if (value.getState() == state) {
                return value;
            }
        }
        return UNDEFINED;
    }

    public byte getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }

}
