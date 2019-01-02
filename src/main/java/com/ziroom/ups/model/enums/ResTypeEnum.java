package com.ziroom.ups.model.enums;

public enum ResTypeEnum {
    MENU(Byte.valueOf("1")),
    ACTION(Byte.valueOf("2"));

    private Byte code;

    ResTypeEnum(Byte code) {
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }
}
