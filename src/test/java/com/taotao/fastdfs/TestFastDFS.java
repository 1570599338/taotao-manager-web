package com.taotao.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.taotao.utils.FastDFSClient;

import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;

/**
 * 测试fastdfs服务器是否正常
 * @author lquan
 *
 */
public class TestFastDFS {

	@Test
	public void uploadFile() throws Exception, IOException, MyException{
		// 1、向工程中添加jar包
		// 2、创建一个配置文件。配置tracker服务器地址
		// 3、加载配置文件
		ClientGlobal.init("F:/workspace-maven/taotao-manager-web/src/main/resources/resource/client.conf");
		// 4、创建一个TrackerClinet对象
		TrackerClient trackerClient = new TrackerClient();
		// 5,使用TrackerCline对象获得trackerServer对象
		TrackerServer trackerServer= trackerClient.getConnection();
		// 6，创建一个StorageServer的引用null就可以
		StorageServer storageServer =null;
		// 7、创建一个StorageClinet对象。TrackerServer，StrorageServer两个参数
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		// 8、使用StorageClinet对象上传文件。
		String[] str = storageClient.upload_file("D:/AMS渠道监控部-刘劝.jpg", "jpg", null);
		for(String s:str){
			System.out.println("** "+s);
		}
	}
	
	@Test
	public void testFastDFS() throws Exception{
		FastDFSClient fastDFSClient = new FastDFSClient("F:/workspace-maven/taotao-manager-web/src/main/resources/resource/client.conf");
		String path = fastDFSClient.uploadFile("C:/Users/lquan/Pictures/Camera Roll/mmexport1500479201259.jpg");
		System.out.println("****"+path);
	}
	
}
