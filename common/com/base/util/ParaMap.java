package com.base.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import com.base.util.DateUtils;

public class ParaMap extends TreeMap {
	private static final Logger log = Logger
			.getLogger(com.base.util.ParaMap.class);
	private static final long serialVersionUID = 1L;
	private static final String boolTrueValue = "true;1;yes;ok";
	private static final boolean boolNullValue = false;
	private static final boolean boolEmptyValue = false;

	public ParaMap() {
	}

	public ParaMap(Map map) {
		if (map != null)
			putAll(map);
	}

	public Object put(Object obj, Object obj1) {
		String s = String.valueOf(obj);
		return super.put(s, obj1);
	}

	public Object get(Object obj) {
		return super.get(obj);
	}

	public String getString(String s) {
		String s1 = null;
		if (containsKey(s))
			s1 = String.valueOf(get(s));
		return s1;
	}

	public Double getDouble(String s) {
		if (containsKey(s)) {
			String s1 = getString(s);
			Double double1 = Double.valueOf(Double.parseDouble(s1));
			return double1;
		} else {
			return null;
		}
	}

	public Double getDouble(String s, Double double1) {
		Double double2 = getDouble(s);
		if (double2 != null)
			return double2;
		else
			return double1;
	}

	public Integer getInteger(String s) {
		if (containsKey(s)) {
			String s1 = getString(s);
			try {
				int i = Integer.parseInt(s1);
				return Integer.valueOf(i);
			} catch (Exception exception) {
				return null;
			}
		} else {
			return null;
		}
	}

	public int getInt(String s, int i) {
		Integer integer = getInteger(s);
		if (integer == null)
			return i;
		else
			return integer.intValue();
	}

	public int getInt(String s) {
		return getInt(s, 0);
	}

	public Long getLong(String s) {
		if (containsKey(s)) {
			String s1 = getString(s);
			long l = Long.parseLong(s1);
			return Long.valueOf(l);
		} else {
			return null;
		}
	}

	public BigDecimal getBigDecimal(String s) {
		BigDecimal bigdecimal = null;
		if (containsKey(s)) {
			String s1 = getString(s);
			if (s1 != null && !"".equals(s1) && !s1.equalsIgnoreCase("null"))
				bigdecimal = new BigDecimal(s1);
		}
		return bigdecimal;
	}

	public Date getDate(String s) {
		if (containsKey(s)) {
			String s1 = getString(s);
			return DateUtils.getDate(s1);
		} else {
			return null;
		}
	}

	public List getList(String s) {
		Object obj = get(s);
		return (List) obj;
	}

	public List getFields() {
		return getList("fs");
	}

	public int getFieldCount() {
		List list = getFields();
		if (list == null)
			return -1;
		else
			return list.size();
	}

	public boolean hasField(String s) {
		return getFieldIndex(s) != -1;
	}

	public int getFieldIndex(String s) {
		List list = getFields();
		if (list == null)
			return -1;
		for (int i = 0; i < list.size(); i++) {
			ParaMap paramap = (ParaMap) list.get(i);
			if (s.equals(paramap.getString("name")))
				return i;
		}
		return -1;
	}

	public String getField(int i) {
		List list = getFields();
		if (list == null)
			return null;
		else
			return String.valueOf(list.get(i));
	}

	public List getRecords() {
		return getList("rs");
	}

	public int getRecordCount() {
		List list = getRecords();
		if (list == null)
			return -1;
		else
			return list.size();
	}

	public ParaMap clone() {
		ParaMap paramap = new ParaMap();
		paramap.putAll(this);
		return paramap;
	}
	//.............
}
