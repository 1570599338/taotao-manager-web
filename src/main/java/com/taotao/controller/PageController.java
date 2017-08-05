package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示Controller
 * @author lquan
 *
 */
@Controller
public class PageController {
	
	@RequestMapping(value="/")
	public String showIndex(){
		return "index";
	}
	
	
	/**
	 * 相应通用页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}

}
