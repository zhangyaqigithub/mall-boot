package com.edu.springboot.service;

import java.util.List;


import com.edu.springboot.model.User;
import com.edu.springboot.model.UserExample;

/** 
* @author 作者 Your-Name: ts03033
* @version 创建时间：2020年11月11日 下午3:16:10 
* 类说明 
*/
public interface UserService {
	int deleteByPrimaryKey(Integer pid);

    int insert(User record);
    int insertSelective(User record);
    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer pid);
    
    int updateByExampleSelective( User record,  UserExample example);

    int updateByExample( User record,  UserExample example);
}
