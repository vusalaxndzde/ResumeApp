package com.mycompany.dto;

public class ResponseDTO {

    private String successMsg;
    private Integer errorCode;
    private String errorMsg;
    private Object object;

    private ResponseDTO() {

    }

    public static ResponseDTO of(Object object) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        return responseDTO;
    }

    public static ResponseDTO of(Object object, String successMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setObject(object);
        responseDTO.setSuccessMsg(successMsg);
        return responseDTO;
    }

    public static ResponseDTO of(Integer errorCode, String errorMsg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setErrorCode(errorCode);
        responseDTO.setErrorMsg(errorMsg);
        return responseDTO;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
