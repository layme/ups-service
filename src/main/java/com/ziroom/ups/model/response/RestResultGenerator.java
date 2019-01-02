package com.ziroom.ups.model.response;

/**
 * @author
 * @create 2018-03-21 17:08
 * Description: 返回结果生成器
 */
public class RestResultGenerator {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 500;
    public static final Integer NOT_FOUND = 404;
    /**
     * 生成返回对象的一般格式
     * @param code
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genResult(Integer code, T body, String message) {
        RestResult<T> restResult = RestResult.newInstance();
        restResult.setCode(code);
        restResult.setBody(body);
        restResult.setMessage(message);
        return restResult;
    }

    /**
     * 成功时的返回格式
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T body) {
        return genResult(RestResultGenerator.SUCCESS, body, null);
    }

    /**
     * 失败时的返回格式
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(String message) {
        return genResult(RestResultGenerator.ERROR, null, message);
    }
}
