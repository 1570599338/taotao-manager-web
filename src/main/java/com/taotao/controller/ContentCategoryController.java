package com.taotao.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;

/**
 * 内容分类管理Controller
 * @author lquan
 *
 */
@Controller
public class ContentCategoryController {
	
	@Resource(name="contentCategoryServiceA")
	private ContentCategoryService contentCategoryService;
	
	
	/**
	 * 获取分类信息
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategory(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<EasyUITreeNode> list = this.contentCategoryService.getContentCategoryList(parentId);
		return list;
	}
	
	
	/**
	 * 添加分类信息
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("content/category/create")
	@ResponseBody
	public TaotaoResult addContentCategory(Long parentId,String name){
		TaotaoResult result = this.contentCategoryService.addContentCategory(parentId, name);
		
		return result;
	}
	
}
