package com.ziroom.ups.exception;

import com.ziroom.ups.model.response.RestResult;
import com.ziroom.ups.model.response.RestResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author
 * @create 2018-03-21 17:18
 * Description: 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class ResultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    public <T> RestResult<T> exceptionHandler(Exception e) {
        log.error("meet an Exception: {}", e);
        return RestResultGenerator.genErrorResult(e.getMessage());
    }
}
