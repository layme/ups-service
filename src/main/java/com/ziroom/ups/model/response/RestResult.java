package com.ziroom.ups.model.response;

import lombok.Data;

/**
 * @author
 * @create 2018-03-21 17:04
 * Description: 统一返回该对象给前端，data携带具体数据
 */
@Data
public class RestResult<T> {
    private Integer code;
    private String message;
    private T body;

    private RestResult() {}

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }
}
