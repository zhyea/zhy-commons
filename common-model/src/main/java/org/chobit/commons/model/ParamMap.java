package org.chobit.commons.model;

import java.util.LinkedHashMap;

/**
 * 对于Map的一个封装
 *
 * @author robin
 */
public class ParamMap<V> extends LinkedHashMap<String, V> {


	private static final long serialVersionUID = 8435616761630448165L;


	public ParamMap() {
	}


	public ParamMap(int initialCapacity) {
		super(initialCapacity);
	}


	public boolean getBool(String key) {
		return getBool(key, false);
	}


	public boolean getBool(String key, boolean defaultValue) {
		V v = get(key);
		if (v instanceof Boolean) {
			return (Boolean) v;
		}
		return defaultValue;
	}


	public int getInt(String key) {
		return getInt(key, 0);
	}


	public int getInt(String key, int defaultValue) {
		V v = get(key);
		if (v instanceof Integer) {
			return (Integer) v;
		}
		return defaultValue;
	}


	public long getLong(String key) {
		return getLong(key, 0L);
	}


	public long getLong(String key, long defaultValue) {
		V v = get(key);
		if (v instanceof Long) {
			return (Long) v;
		}
		if (v instanceof Integer) {
			return ((Integer) v).longValue();
		}
		return defaultValue;
	}


	public double getDouble(String key) {
		return getDouble(key, 0.0);
	}


	public double getDouble(String key, double defaultValue) {
		V v = get(key);
		if (v instanceof Double) {
			return (Double) v;
		}
		return defaultValue;
	}


	public String getStr(String key) {
		return getStr(key, null);
	}

	public String getStr(String key, String defaultValue) {
		V v = get(key);
		if (v instanceof String) {
			return (String) v;
		}
		return defaultValue;
	}


	public V get(String key) {
		if (!super.containsKey(key)) {
			return null;
		}
		return super.get(key);
	}

}
