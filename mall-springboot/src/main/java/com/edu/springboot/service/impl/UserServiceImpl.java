package com.edu.springboot.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springboot.dao.UserMapper;
import com.edu.springboot.model.User;
import com.edu.springboot.model.UserExample;
import com.edu.springboot.service.UserService;
/** 
* @author 作者 Your-Name: ts03033
* @version 创建时间：2020年11月11日 下午3:19:17 
* 类说明 
*/
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	

	@Override
	public int deleteByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		int i = userMapper.insert(record);
		return i;
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	@Override
	public User selectByPrimaryKey(Integer pid) {
		User user = userMapper.selectByPrimaryKey(pid);
		return user;
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		int i = userMapper.updateByExampleSelective(record, example);
		return i;
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		int i = userMapper.updateByExample(record, example);
		return i;
	}

	@Override
	public int insertSelective(User record) {
		int i = userMapper.insertSelective(record);
		return i;
	}
	
}
