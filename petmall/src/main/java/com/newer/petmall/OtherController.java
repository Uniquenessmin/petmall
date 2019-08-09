package com.newer.petmall;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@Controller
@RequestMapping("/o")
public class OtherController {

	
	@GetMapping("/cb")
	public String logout(HttpSession session,RedirectAttributesModelMap m) {
		//会话失效
		session.invalidate();
		
		//重定向后如何获得原有请求参数或数据
		//1.编码后追加到URL后面
		m.addAttribute("info", "重定向后获得数据");
		
		//2.存入重定向后的控制器model（RedirectAttributesModelMap）中，重定向后的视图可以直接读取
		m.addFlashAttribute("a", "hello，info");
		
		
		//重定向 302 （登录成功、创建、更新需要重定向）
		return "redirect:/login";
	}
	
	
	@GetMapping("/ab")
	public String abount() {
		
		return "jsp/account/abount";
	}
	
	@GetMapping("/db")
	public ModelAndView home2(ModelAndView mv,HttpSession session) {
		 
		
		//视图
		mv.setViewName("jsp/account/index");

		//数据
		ArrayList< String > list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("v");
		
		mv.addObject("mList", list);
		session.setAttribute("reqList", list);
		return mv;
	}
}
