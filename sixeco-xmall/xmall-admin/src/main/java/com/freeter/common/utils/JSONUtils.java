

package com.freeter.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class JSONUtils {

	/**
	 * 将json字符串转换为Map集合
	 * 
	 * @author tanxin
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String json) {
		Map<String, Object> result = JSONObject.parseObject(json, new TypeReference<Map<String, Object>>() {
		});
		return result;
	}

	// 将jsonArray字符串转换成List集合
	public static List jsonToList(String json, Class beanClass) {
		if (StringUtils.isNotBlank(json)) {
			// 这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
			return JSONObject.parseArray(json, beanClass);
		} else {
			return null;
		}
	}

	// List集合转换为json
	public static JSON listToJson(List list) {
		JSON json = (JSON) JSON.toJSON(list);
		return json;
	}

	public static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
		List list = new ArrayList();
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			HashMap map = new HashMap<String, Object>();
			for (Map.Entry entry : jsonObject.entrySet()) {
				if (entry.getValue() instanceof JSONArray) {
					map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
				} else {
					map.put((String) entry.getKey(), entry.getValue());
				}
			}
			list.add(map);
		}
		return list;
	}

}