package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

/**
 * 内容管理Controller
 * @author lquan
 *
 */
@Controller
public class ContentController {
	
	@Resource(name="contentService")
	private ContentService contentService;
	
	/**
	 * 添加分类信息
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult addContentCategory(TbContent content){
		TaotaoResult result = this.contentService.addContent(content);
		
		return result;
	}

}
