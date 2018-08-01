package com.freeter.common.utils;

public enum ResultCode {

	S_OK(200, "ok"),

	S_FAIL(500, "fail"),

	S_PARAM_EMPTY(501, "参数不存在"),

	S_PARAM_ERROR(502, "参数异常"),

	S_DATA_NOT_EXIST(503, "数据不存在"),

	S_OBJECT_ALREADY_EXISTS(504, "数据已存在");

	private int code;

	private String msg;

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
