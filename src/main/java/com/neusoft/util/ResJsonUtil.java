package com.neusoft.util;

import com.neusoft.domain.ResJson;

/**
 * 返回成功信息和错误信息为Json的工具
 * 
 * @author sky
 *
 */
public class ResJsonUtil {

	/**
	 * 成功的返回信息
	 * 
	 * @param data
	 *            对象数据
	 * @return
	 */
	public static ResJson success(Object data) {

		ResJson json = new ResJson();
		json.setCode(0);
		json.setMsg("成功");
		json.setData(data);

		return json;
	}

	/**
	 * 自定义信息的成功返回(带对象数据)
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static ResJson success(Object data, String msg) {

		ResJson json = new ResJson();
		json.setCode(0);
		json.setMsg(msg);
		json.setData(data);

		return json;
	}

	/**
	 * 自定义信息的成功返回(不带对象数据)
	 * 
	 * @param data
	 * @param msg
	 * @return
	 */
	public static ResJson success(String msg) {

		ResJson json = new ResJson();
		json.setCode(0);
		json.setMsg(msg);

		return json;
	}

	// 成功无信息的返回
	public static ResJson success() {

		return success(null);
	}

	/**
	 * 错误的返回信息
	 * 
	 * @param code
	 *            错误码
	 * @param msg
	 *            错误信息
	 * @return
	 */
	public static ResJson error(Integer code, String msg) {

		ResJson json = new ResJson();
		json.setCode(code);
		json.setMsg(msg);
		return json;

	}

}
