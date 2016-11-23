package com.zabbix.sisyphus.uc.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.common.UserDetail;
import com.zabbix.sisyphus.uc.entity.Function;
import com.zabbix.sisyphus.uc.entity.LoginInfo;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.entity.Staff;
import com.zabbix.sisyphus.uc.repository.LoginInfoDao;
import com.zabbix.sisyphus.uc.repository.StaffDao;

@Component
public class UcUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginInfoDao loginInfoDao;

	@Autowired
	private StaffDao staffDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginInfo loginInfo = loginInfoDao.findByUsernameAndStatus(username, Constants.D00210001);
		if (loginInfo == null) {
			return null;
		} else {

			if (Constants.D00260001.equals(loginInfo.getUserType())) {// 后台用户
				Staff staff = staffDao.findOne(loginInfo.getUserId());
				List<GrantedAuthority> authorities = Lists.newArrayList();
				for(Role role : staff.getRoles()){
					for(Function func : role.getFunctions()){
						authorities.add(new SimpleGrantedAuthority(func.getFunctionCode()));
						authorities.add(new SimpleGrantedAuthority(func.getUrl()));
					}
				}
				return new UserDetail(loginInfo.getUserId(),username, loginInfo.getPassword1(), authorities);
			} else {
				return new UserDetail(loginInfo.getId(),username, loginInfo.getPassword1(), new ArrayList<GrantedAuthority>());
			}

		}
	}

}
