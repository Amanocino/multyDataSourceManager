package org.example.config.Exception;

import lombok.extern.slf4j.Slf4j;
import org.example.common.ResultJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : zhicheng chen
 * @date : 2022/2/16
 * @time : 14:50
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = UnitException.class)
    @ResponseBody
    public ResultJson bizExceptionHandler(HttpServletRequest req, UnitException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return new ResultJson().error(e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultJson exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return new ResultJson().error("发生空指针异常！");
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultJson exceptionHandler(HttpServletRequest req, Exception e){
        log.error("抛出其他异常！原因是:",e);
        return new ResultJson().error(e.getMessage());
    }
}
