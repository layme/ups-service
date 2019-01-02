package com.ziroom.ups.model.enums;

public enum IsDelEnum {
    YES(Byte.valueOf("1")),
    NO(Byte.valueOf("0"));

    private Byte code;

    IsDelEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }
}
