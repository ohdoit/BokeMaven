package com.mgc.controller.system;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mgc.common.ActionResult;
import com.mgc.common.FriendlyException;
import com.mgc.common.MessageUtil;
import com.mgc.common.SystemSecret;
import com.mgc.controller.BaseController;
import com.mgc.entity.system.SystemUser;
import com.mgc.service.system.SystemUserService;

@Controller
//@RestController restful风格
@RequestMapping("/boke")
public class SystemUserController extends BaseController{
	
	
	private Logger log = LoggerFactory.getLogger(SystemUserController.class);
	@Autowired 
	private SystemUserService suService;
	
	@Autowired
	private ResourceBundleMessageSource messagesource;

	
//	@Autowired
//	private HttpSession session;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView login(SystemUser su, Locale locale){
		ModelAndView mav = new ModelAndView();
		su.setPassword(SystemSecret.md5Encode(su.getPassword()));
		SystemUser user = suService.login(su, session);
		if(user!=null){
			//跳转的视图名，即login.jsp
			mav.setViewName("website/index");
			mav.setStatus(HttpStatus.OK);
			mav.addObject("username", user.getAccount());
			session.setAttribute("account", user.getAccount());
			session.setAttribute("isLogin", true);
		}else{
			mav.setStatus(HttpStatus.BAD_REQUEST);
			mav.setViewName("login");
//			mav.addObject("message", MessageUtil.getMessage(request, "loginFailed"));
			mav.addObject("message", messagesource.getMessage( "loginFailed", null, locale));
			mav.addObject("account", su.getAccount());
			mav.addObject("password", su.getPassword());
		}
		return mav;
	}
	
	@RequestMapping(value="/systemUser", method=RequestMethod.GET)
	// 返回json数据，用在类上表示该类所有的方法都返回对象数据
	@ResponseBody
	public SystemUser personInfo(@RequestParam(value="account",required=true) String account){
		SystemUser su = suService.getSystemUser(account);
		return su;
	}
	
	// restful 风格
	@RequestMapping(value="/systemUser", method={RequestMethod.POST})
	public String addSystemUser(String account, String password, ModelMap map){
		if(account==null || account.trim().isEmpty()){
			throw new FriendlyException("账号不能为空", ActionResult.ILLEGAL_PARAM);
		}
		if(password==null || password.trim().isEmpty()){
			throw new FriendlyException("密码不能为空", ActionResult.ILLEGAL_PARAM);
		}
		SystemUser user = new SystemUser(account, SystemSecret.md5Encode(password));
		ActionResult result = new ActionResult();
		suService.save(user);
		result.setStatus(ActionResult.SUCCESS);
		map.put("account", account);
		return "register_success";
	}
	
	// restful 风格
		@RequestMapping(value="/systemUser", method={RequestMethod.PUT})
		@ResponseBody
		public ActionResult updateSystemUser(String account, String password){
			if(account==null || account.trim().isEmpty()){
				throw new FriendlyException("账号不能为空", ActionResult.ILLEGAL_PARAM);
			}
			if(password==null || password.trim().isEmpty()){
				throw new FriendlyException("密码不能为空", ActionResult.ILLEGAL_PARAM);
			}
			SystemUser user = new SystemUser(account, SystemSecret.md5Encode(password));
			ActionResult result = new ActionResult();
			suService.save(user);
			result.setStatus(ActionResult.SUCCESS);
			return result;
		}
	
	@ModelAttribute
	public void init(ModelMap model){
		model.put("param", "初始化参数");
		model.addAttribute("attribute", "模型数据");
	}
	
	@RequestMapping(value="/systemUser2", method=RequestMethod.POST)
	@ResponseBody
	public SystemUser personInfo2(String account, ModelMap model){
		System.out.println("----------ModelMap----------"); 
		model.keySet().forEach(key->System.out.println(key+"="+model.get(key)));
		return suService.getSystemUser(account);
	}
}
