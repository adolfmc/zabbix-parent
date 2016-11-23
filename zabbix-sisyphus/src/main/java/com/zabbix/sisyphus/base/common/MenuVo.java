package com.zabbix.sisyphus.base.common;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 左侧主菜单
 * 
 * @author admin
 * 
 */
public class MenuVo {
	private long id;
	private String name;
	private String code;
	private String url;
	
	
	private int ord;
	
	
	private Set<MenuVo> children = new TreeSet<MenuVo>(new Comparator<MenuVo>() {
		@Override
		public int compare(MenuVo o1, MenuVo o2) {
			return o1.ord - o2.ord;
		}
	});
	
	
	
	
//	private List<MenuVo> children ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public List<MenuVo> getChildren() {
//		return children;
//	}
//
//	public void setChildren(List<MenuVo> children) {
//		this.children = children;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public Set<MenuVo> getChildren() {
		return children;
	}

	public void setChildren(Set<MenuVo> children) {
		this.children = children;
	}
	
}
