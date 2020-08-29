package com.limbo.search.sys.dao;

import com.limbo.search.sys.po.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单操作
 * @author Maochao-zhu
 *
 */
@Mapper
public interface RoleDao {
	public Integer insertRole(Role role);
	public Integer deleteRoleById(String[] ids);
	public Integer updateRoleById(Role role);
	public Role getRoleById(Integer id);
	public List<Role> getRoleList(Role role);
	public Integer getRoleListCount(Role role);
	 
}
