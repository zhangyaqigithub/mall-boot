package com.edu.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/** 
* @author 作者 Your-Name: ts03033
* @version 创建时间：2020年11月11日 下午3:23:16 
* 类说明 
*/
@Configuration
@MapperScan("com.edu.springboot.dao")
public class MybatisConfig {

}
