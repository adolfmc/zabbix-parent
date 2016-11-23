package com.zabbix.sisyphus.base.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.zabbix.sisyphus.uc.entity.Staff;
import com.zabbix.sisyphus.uc.repository.StaffDao;

/**
 * 
 * @author 提供取用户和用户权限的方法
 */
public class SecurityHelper {

	/**
	 * 得到登录用户
	 * 
	 * @return
	 */
	public static UserDetails getUserDetails() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (null == au)
			return null;
		UserDetails userdetails = (UserDetails) au.getPrincipal();
		return userdetails;
	}

	/**
	 * 获取登陆用户ID
	 * 
	 * @return
	 */
	public static Long getLoginUserId() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null) {
			return null;
		} else {
			UserDetail user = (UserDetail) au.getPrincipal();
			return user.getId();
		}
	}

	/**
	 * 获取当前登陆的员工
	 * 
	 * @return
	 */
	public static Staff getLonginStaff() {
		Long id = getLoginUserId();
		if (id != null) {
			StaffDao staffDao = SpringContextHelper.getBean(StaffDao.class);
			return staffDao.findOne(id);
		}
		return null;
	}


	public static void putAttr(String key, Object value) {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null)
			throw new RuntimeException("用户未登录");
		if (key == null || value == null)
			throw new RuntimeException("key或value不能为空");
		UserDetail user = (UserDetail) au.getPrincipal();
		user.put(key, value);
	}

	public static Object getAttr(String key) {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null)
			throw new RuntimeException("用户未登录");
		if (key == null)
			throw new RuntimeException("key不能为空");

		UserDetail user = (UserDetail) au.getPrincipal();
		return user.get(key);
	}
	
	/**
	 * 判断用户是不是有这个权限 true 有权限
	 * 
	 * @param permission
	 * @return
	 */
	public static boolean hasPermision(String permission) {
		if (permission != null && permission.length() > 1) {
			Map<String, String> map = getPermissionNames();
			if (map.get(permission) != null)
				return true;
		}
		return false;
	}
	/**
	 * 得到用户有的权限用逗号割开的
	 * 
	 * @return
	 */
	public static Map<String, String> getPermissionNames() {
		Map<String, String> map = new HashMap<String, String>();
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> permissions = au.getAuthorities();
		for (Iterator<? extends GrantedAuthority> i = permissions.iterator(); i.hasNext();) {
			GrantedAuthority permission = (GrantedAuthority) i.next();
			if (permission.getAuthority() != null) {
				map.put(permission.getAuthority(), permission.getAuthority());
			}
		}
		return map;
	}
}
