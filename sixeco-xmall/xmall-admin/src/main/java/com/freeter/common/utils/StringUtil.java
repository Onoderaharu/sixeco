package com.freeter.common.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	private static double EARTH_RADIUS = 6378.137;// 半径

	public static boolean isEmptyStr(String tpoo) {
		if (tpoo == null || "null".equalsIgnoreCase(tpoo.trim()) || "".equals(tpoo.trim())
				|| "NaN".equalsIgnoreCase(tpoo.trim())) {
			return true;
		}
		return false;
	}

	public static String likeLeft(String str) {
		if (StringUtils.isNotBlank(str)) {
			return "%" + str;
		}
		return str;
	}

	public static String likeRight(String str) {
		if (StringUtils.isNotBlank(str)) {
			return str + "%";
		}
		return str;
	}

	public static String like(String str) {
		if (StringUtils.isNotBlank(str)) {
			return "%" + str + "%";
		}
		return str;
	}

	public static String getMap(Map<String, Object> map, String msg) {
		Object object = map.get(msg);
		if (object == null) {

			return "";
		}

		return object.toString();
	}

	/**
	 * 依据经纬度计算两点之间的距离 GetDistance:(). <br/>
	 * 
	 * 
	 * @author chiwei
	 * @param lat1
	 *            1点的纬度
	 * @param lng1
	 *            1点的经度
	 * @param lat2
	 *            2点的纬度
	 * @param lng2
	 *            2点的经度
	 * @return 距离 单位 米
	 * @since JDK 1.6
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double s;
		try {
			double radLat1 = getRadian(lat1);
			double radLat2 = getRadian(lat2);
			double a = radLat1 - radLat2;// 两点纬度差
			double b = getRadian(lng1) - getRadian(lng2);// 两点的经度差
			s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
					+ Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
			s = s * EARTH_RADIUS;
			return s * 1000;
		} catch (Exception e) {
			e.printStackTrace();
			return 0d;
		}

	}

	/**
	 * 自动换算单位 单位是m 时 向上晋升km
	 * 
	 * Unit m米,cm厘米,dm分米，km千米,mi英里
	 */
	public static String getDistance(double lat1, double lng1, double lat2, double lng2, String Unit) {
		BigDecimal dist = new BigDecimal(getDistance(lat1, lng1, lat2, lng2));
		DecimalFormat decimalFormat = null;
		if ("m".equals(Unit)) {
			Unit = "米";
			if (dist.doubleValue() > 1000) {
				Unit = "km";
			}
		} else if ("cm".equals(Unit)) {
			Unit = "厘米";
			dist.multiply(new BigDecimal("100"));
		} else if ("dm".equals(Unit)) {
			Unit = "分米";
			dist.multiply(new BigDecimal("10"));

		} else if ("km".equals(Unit)) {
			Unit = "千米";
			decimalFormat = new DecimalFormat("0.0");
			dist.divide(new BigDecimal("1000"));
		} else if ("mi".equals(Unit)) {
			Unit = "英里";
			decimalFormat = new DecimalFormat("0.0");
			dist.divide(new BigDecimal("1609.344"));
		}
		if (decimalFormat == null) {
			decimalFormat = new DecimalFormat("0");
		}

		return decimalFormat.format(dist).toString() + Unit;
	}

	/**
	 * 角度弧度计算公式 rad:(). <br/>
	 * 
	 * 360度=2π π=Math.PI
	 * 
	 * x度 = x*π/360 弧度
	 * 
	 * @author chiwei
	 * @param d
	 * @return
	 * @since JDK 1.6
	 */
	private static double getRadian(double degree) {
		return degree * Math.PI / 180.0;
	}

	/**
	 * 实体转map
	 * 
	 * @param ob
	 * @param map
	 * @return
	 */
	public static Map<String, Object> entityToMap(Object ob, Map<String, Object> map) {
		if (ob == null) {
			return null;
		}
		if (map == null) {
			map = new HashMap<>();
		}
		try {
			Class<? extends Object> obClass = ob.getClass();
			Field[] fields = obClass.getFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String name = field.getName();
				Object object = field.get(ob);
				if (object != null) {
					map.put(name, object);
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Object[]> splitArr(Object[] obj, Integer size) {
		List<Object[]> listObj = new ArrayList<>();
		List<Object> obs = new ArrayList<>();
		for (Object objects : obj) {
			if (obs.size() >= size) {
				listObj.add(obs.toArray());
				obs = new ArrayList<>();
			}
			obs.add(objects);
		}
		return listObj;

	}

}
