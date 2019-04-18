package xyz.kingsword.gateway.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: wzh date: 2019-04-14 20:49
 * @version: 1.0
 **/
@Data
public class ResultBean<T> implements Serializable {
//    @JSONField(serialize = false)
    private ExceptionEnum exceptionData;
    private String message;
    private int code;
    private T data;

    public ResultBean(ExceptionEnum exceptionEnum) {
        this.exceptionData = exceptionEnum;
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    public ResultBean(){
        this.code=0;
    }

}
