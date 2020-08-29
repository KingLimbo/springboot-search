package com.limbo.search.sys.service.impl;

import com.limbo.search.common.BasePageData;
import com.limbo.search.common.WebResponseCode;
import com.limbo.search.sys.dao.UserRelDao;
import com.limbo.search.sys.po.UserRel;
import com.limbo.search.sys.service.UserRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserRelServiceImpl")
public class UserRelServiceImpl implements UserRelService{
	
	@Resource
	UserRelDao userRelDao;
	
	@Override
	public BasePageData insertUserRel(Integer uid, Integer tid) {
		
		BasePageData data = new BasePageData();
		
		userRelDao.insertUserRel(uid, tid);
		data.setCode(WebResponseCode.SUCCESS);
		data.setMsg("操作成功!");
		
		return data;
	}

	@Override
	public Integer deleteUserRelByUid(Integer uid) {
		return userRelDao.deleteUserRelByUid(uid);
	}

	@Override
	public List<UserRel> getUserRelListByUid(Integer uid) {
		return userRelDao.getUserRelListByUid(uid);
	}

}
