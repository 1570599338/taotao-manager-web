package com.taotao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.utils.FastDFSClient;
import com.taotao.utils.JsonUtils;

/**
 * 
 * 上传图片Controller
 * @author lquan
 *
 */
@Controller
public class PictureController {
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile) throws Exception{
		// 接受文件
		
		// 获取扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String exName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);// 扩展名没有.
		// 上传图片到服务器
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		String url = fastDFSClient.uploadFile(uploadFile.getBytes(), exName);
		url = IMAGE_SERVER_URL +url;
		System.out.println("**"+url);
		// 响应上传图片的URL
		Map<String,Object> result = new HashMap<>();
		result.put("error",0);
		result.put("url", url);
		
		return JsonUtils.objectToJson(result);
	}

}
