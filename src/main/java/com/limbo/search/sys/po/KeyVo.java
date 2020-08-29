package com.limbo.search.sys.po;

import com.limbo.search.common.BasePo;

/**
 * 键值对信息 
 * @author Maochao-zhu
 *
 */
public class KeyVo extends BasePo{
	private Object key;
	private Object piKey;
	private Object value;
	
	public KeyVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object getPiKey() {
		return piKey;
	}


	public void setPiKey(Object piKey) {
		this.piKey = piKey;
	}


	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
