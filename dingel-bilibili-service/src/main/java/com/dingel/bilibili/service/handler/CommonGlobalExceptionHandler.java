package com.dingel.bilibili.service.handler;


import com.dingel.bilibili.domain.JsonResponse;
import com.dingel.bilibili.domain.exception.ConditionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)     //只要抛出异就用这个方法执行
    @ResponseBody
    public JsonResponse<String> commExceptionHandler(HttpServletRequest request , Exception e){
        String errorMsg = e.getMessage();
        if(e instanceof ConditionException){
            String errorCode = ((ConditionException)e).getCode();
            return new JsonResponse<>(errorCode);
        }else{
            return new JsonResponse<>("500",errorMsg);
        }
    }

}
