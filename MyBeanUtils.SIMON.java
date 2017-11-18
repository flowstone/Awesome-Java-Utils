package org.xueyao.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	public static void populate(Object obj, Map<String, String[]> map) {
		try {
			// 自己创建一个转换器
			DateConverter DateConverter = new DateConverter();
			// 设置时间格式
			DateConverter.setPattern("yyyy-MM-dd");
			// 将转换器注册到ConvertUtils上
			ConvertUtils.register(DateConverter, java.util.Date.class);

			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> T populate(Class<T> clazz, Map<String, String[]> map) {
		T t = null;
		try {
			t = clazz.newInstance();
			// 自己创建一个转换器
			DateConverter DateConverter = new DateConverter();
			// 设置时间格式
			DateConverter.setPattern("yyyy-MM-dd");
			// 将转换器注册到ConvertUtils上
			ConvertUtils.register(DateConverter, java.util.Date.class);
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
