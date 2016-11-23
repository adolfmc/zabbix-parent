package com.zabbix.sisyphus.base.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.common.ExceptionVo;
import com.zabbix.sisyphus.base.common.MenuVo;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.base.common.SecurityHelper;
import com.zabbix.sisyphus.base.common.UserDetail;
import com.zabbix.sisyphus.uc.entity.Function;
import com.zabbix.sisyphus.uc.entity.Log;
import com.zabbix.sisyphus.uc.entity.LoginInfo;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.service.LogService;
import com.zabbix.sisyphus.uc.service.LoginInfoService;

/**
 * index Controller
 * 
 *
 */
@Controller
public class IndexController {

	@Autowired
	private LoginInfoService commonInService;
	/**
	 * login 登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	/**
	 * index 首页界面
	 * 
	 * @return
	 */
	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("staff", SecurityHelper.getLonginStaff());
		LoginInfo loginInfo = commonInService.findAllByUserIdAndUserType(SecurityHelper.getLonginStaff().getId());
		model.addAttribute("loginInfo", loginInfo);
		model.addAttribute("role", SecurityHelper.getLonginStaff().getRoles().size()==0?new Role():SecurityHelper.getLonginStaff().getRoles().get(0));
		return "/index";
	}

	/**
	 * 将function权限转换为menu
	 * 
	 * @param function
	 * @param menuVo
	 */
	private void convert(Function function, MenuVo menuVo, Set<Long> includeIds) {

		Long id = function.getId();
		if (!includeIds.contains(id))
			return;

		menuVo.setId(function.getId());
		menuVo.setName(function.getName());
		menuVo.setUrl(function.getUrl());
		menuVo.setCode(function.getFunctionCode());
		menuVo.setOrd(function.getOrd());
		// List<MenuVo> list = new
		// ArrayList<MenuVo>(function.getChildren().size());

		for (Function func : function.getChildren()) {
			if (includeIds.contains(func.getId())) {
				MenuVo vo = new MenuVo();
				convert(func, vo, includeIds);
				menuVo.getChildren().add(vo);
			}
		}
	}

	/**
	 * 获取首页index的菜单menu
	 * 
	 * @return
	 */
	@RequestMapping("/getMenu")
	@ResponseBody
	public MenuVo getMenu() {
		Function function = commonInService.findRootFunction();
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Function> functions = commonInService.findStaff(user.getId()).getFunctions();

		Set<Long> ids = new HashSet<Long>();
		ids.add(function.getId());
		for (Function func : functions) {
			ids.add(func.getId());
		}

		MenuVo menuVo = new MenuVo();
		convert(function, menuVo, ids);
		return menuVo;
	}
	
	@Autowired
	private LogService logService;
	/**
	 * 捕获抛出的异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public ResultVo exceptionHandler(Exception e) {
		Log log = new Log();
		log.setLogDate(new Date());
		log.setStaffId(SecurityHelper.getLonginStaff());
		log.setLogType(Constants.D00580002);
		try {
			log.setIp(String.valueOf(SecurityHelper.getAttr("ip")));
		} catch (Exception e2) {
		}
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		String str = writer.toString();
		str = str.substring(0, Math.min(str.length(), 1000));
		log.setOperatorDesc(str);

		logService.saveOrUpdate(log);
//		e.printStackTrace();
		return new ExceptionVo(e);
	}
	
	
	
}
