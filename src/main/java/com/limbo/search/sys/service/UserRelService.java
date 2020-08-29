package com.limbo.search.sys.service;

import com.limbo.search.common.BasePageData;
import com.limbo.search.sys.po.UserRel;

import java.util.List;

/**
 * Service类
 * @author Maochao-zhu
 *
 */
public interface UserRelService {
	
	//插入关系
	public BasePageData insertUserRel(Integer uid, Integer tid);
	
	//删除关系
	public Integer deleteUserRelByUid(Integer uid);
	
	//根据用户ID获取被管理的人
	public List<UserRel> getUserRelListByUid(Integer uid);
	
	
}
