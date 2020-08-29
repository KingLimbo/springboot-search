package com.limbo.search.sys.service;

import com.limbo.search.sys.po.Role;

import java.util.List;

/**
 * 角色
 * @author Maochao-zhu
 *
 */
public interface RoleService {
	public Integer insertRole(Role role);
	public Integer deleteRoleById(String[] ids);
	public Integer updateRoleById(Role role);
	public Role getRoleById(Integer id);
	public List<Role> getRoleList(Role role);
	public Integer getRoleListCount(Role role);

}
