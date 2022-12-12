package com.losgif.senbeiapi.responses;

import lombok.Data;

@Data
public class ApiResponse {
    private int code;
    private String msg;
    private Object data;

    public static ApiResponse success(Object data) {
        return success(200, "操作成功", data);
    }
    public static ApiResponse success(int code, String msg, Object data) {
        ApiResponse r = new ApiResponse();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static ApiResponse fail(String msg) {
        return fail(400, msg, null);
    }
    public static ApiResponse fail(String msg, Object data) {
        return fail(400, msg, data);
    }
    public static ApiResponse fail(int code, String msg, Object data) {
        ApiResponse r = new ApiResponse();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
