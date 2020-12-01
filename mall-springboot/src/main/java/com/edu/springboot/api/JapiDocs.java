package com.edu.springboot.api;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/** 
* @author 作者 Your-Name: ts03033
* @version 创建时间：2020年11月12日 上午10:56:27 
* 类说明 
*/
public class JapiDocs {
	public static void main(String[] args) {
		DocsConfig config = new DocsConfig();
		config.setProjectPath("D:\\eclipseFile\\mall-springboot"); // 项目根目录
		config.setProjectName("mall-springboot"); // 项目名称
		config.setApiVersion("V1.0");       // 声明该API的版本
		config.setDocsPath("D:\\API\\Japidocs"); // 生成API 文档所在目录
		config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
		Docs.buildHtmlDocs(config); // 执行生成文档
	}
}
