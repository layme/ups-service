package com.ziroom.ups.model.enums;

public enum IsUseStatusEnum {
    START(Byte.valueOf("1")),
    STOP(Byte.valueOf("0"));

    private Byte code;

    IsUseStatusEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }
}
