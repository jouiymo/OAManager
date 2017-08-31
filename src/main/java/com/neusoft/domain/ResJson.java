package com.neusoft.domain;

/**
 * 返回json
 * 
 * @author sky
 *
 * @param <T>
 */
public class ResJson<T> {

	// 数据内容
	private T data;
	// 状态代码
	private Integer code;
	// 状态信息
	private String msg;


	public ResJson() {
		super();
	}

	// 带所有参数的构造函数
	public ResJson(T data, Integer code, String msg) {
		super();
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
