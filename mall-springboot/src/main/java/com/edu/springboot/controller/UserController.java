package com.edu.springboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.springboot.model.User;
import com.edu.springboot.model.UserExample;
import com.edu.springboot.service.UserService;

import io.github.yedaxia.apidocs.Ignore;

/**
 * @description 用户接口
 * @author 作者 Your-Name: ts03033
 * @version 创建时间：2020年11月11日 下午3:33:07 类说明
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/hello") 
	@ResponseBody
	public String getHello() {
		return "hello world! jenkins CI-CD！";
	}
	/**
	 * 查询全部
	 * @return
	 */
	@RequestMapping("/user/list") 
	@ResponseBody
	public List<User> getListUser() {
		UserExample example = new UserExample();
		List<User> list = userService.selectByExample(example);
		return list;
	}
	/**
	 * 查询用户
	 * @author 作者 Your-Name: ts03033
	 * @param pid 用户Id
	 * */
	@GetMapping("/user/{pid}")
	@ResponseBody
	public User getUserById(@PathVariable(name="pid",required=false) Integer pid) {
		User user = userService.selectByPrimaryKey(pid);
		return user;
	}
	/**
	 * 查询用户2
	 * @author 作者 Your-Name: ts03033
	 * @param pid
	 * */
	@GetMapping("/user")
	@ResponseBody
	public User getUserById2(@PathParam("pid") Integer pid) {
		User user = userService.selectByPrimaryKey(pid);
		return user;
	}
	/**
	 * 修改用户
	 * @param pid
	 * */
	@PutMapping("/user/update")
	@ResponseBody
	public String UpdateUser(@PathParam("pid") Integer pid) {
		User u = new User();
		u.setPname("蜘蛛精");
		UserExample e = new UserExample();
		e.createCriteria().andPidEqualTo(pid);
		// int i = userService.updateByExample(u, e); //属性全部修改 否则报错
		int i = userService.updateByExampleSelective(u, e);
		return i > 0 ? "success" : "false";
	}
	/**
	 * 增加用户1
	 * @param user
	 * */
	@PostMapping("/user/add")
	@ResponseBody
	public String addUser(User user) {
		// psotMan使用 param输入参数 和在body /form-data 中输入参数一样可以添加 但是无法触动自动时间戳
		int i = userService.insert(user);
		return i > 0 ? "success" : "false";
	}

	/**
	 * 增加用户2
	 * @param user 
	 * @return
	 */
	@PostMapping("/user/add2")
	@ResponseBody
	public String addUser2(User user) {
		// 可以触动时间戳
		int i = userService.insertSelective(user);
		return i > 0 ? "success" : "false";
	}
	
	/**
	 * 增加用户3
	 * @param user 
	 * @return
	 */
	@PostMapping("/user/add3")
	@ResponseBody
	public String addUser3(@RequestBody(required=true) User user) {
		// psotMan 使用 raw模式并调节为JSON格式
		int i = userService.insertSelective(user);
		return i > 0 ? "success" : "false";
	}
	
	
	
	/**
	 * 不使用resultful风格查询
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getuser")
	@ResponseBody
	public User getUserBypId(@RequestParam(value="id",required=true) Integer pid) {
		User user = userService.selectByPrimaryKey(pid);
		return user;
	}

}
