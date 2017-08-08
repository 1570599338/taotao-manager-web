package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;

/**
 * 商品分类管理Controlller
 * @author lquan
 *
 */
@Controller
public class ItemCatConteoller {

	// 引用服务注册进来
	@Autowired
	private ItemCatService itemCatService;
	
	
	/**
	 * 查询商品分类的子类的信息
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0") Long parentId){
		List<EasyUITreeNode> list = this.itemCatService.getItemCatList(parentId);
		
		return list;
	}
	
	
	
	
}
