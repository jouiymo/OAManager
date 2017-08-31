package com.neusoft.util;

import java.lang.reflect.Field;

public class CheckUtil {
	//判断对象所有属性是否为空 有问题！暂弃
	public static boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

	    boolean flag = false;
	    for(Field f : obj.getClass().getDeclaredFields()){
	        f.setAccessible(true);
	        if(f.get(obj) == null){
	            flag = true;
	            return flag;
	        }
	    }
	    return flag;
	}
}
