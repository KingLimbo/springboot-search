package com.limbo.search.sys.service.impl;

import com.limbo.search.sys.dao.RoleDao;
import com.limbo.search.sys.po.Role;
import com.limbo.search.sys.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service实现类
 * @author Maochao-zhu
 *
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService {
	@Resource
	RoleDao roleDao;

	@Override
	public Integer insertRole(Role role) {
		// TODO Auto-generated method stub
		return roleDao.insertRole(role);
	}

	@Override
	public Integer deleteRoleById(String[] ids) {
		// TODO Auto-generated method stub
		return roleDao.deleteRoleById(ids);
	}

	@Override
	public Integer updateRoleById(Role role) {
		// TODO Auto-generated method stub
		return roleDao.updateRoleById(role);
	}

	@Override
	public Role getRoleById(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.getRoleById(id);
	}

	@Override
	public List<Role> getRoleList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.getRoleList(role);
	}

	@Override
	public Integer getRoleListCount(Role role) {
		return roleDao.getRoleListCount(role); 
	}
}
