package com.quantum.leap.productcatalog.web.dto;

public class ResponseModelApi<T>{

    private String code;

    private String message;

    private T body;

    public ResponseModelApi() {}

    public ResponseModelApi(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ReponseModelApi{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
