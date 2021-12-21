package com.amanoisuno.dynamicdatasource.common;

public class ResultJson {

    private Integer result;

    private String message;

    private Object data;

    private Object data1;

    private Object data2;

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultJson() {
    }

    public ResultJson(Integer result, String message, Object data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultJson(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultJson{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Object getData1() {
        return data1;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }
}
