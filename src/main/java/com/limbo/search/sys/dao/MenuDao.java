package com.limbo.search.sys.dao;

import com.limbo.search.sys.po.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单操作
 *
 * @author Maochao-zhu
 */
@Mapper
public interface MenuDao {
    public Integer insertMenu(Menu menu);

    public Integer deleteMenuById(String[] ids);

    public Integer updateMenuById(Menu menu);

    public Menu getMenuById(Integer id);

    public List<Menu> getMenuList(Menu menu);

    public List<Menu> getMenuListByPid(@Param("pid") Integer pid, @Param("cname") String cname);

    public Integer getMenuListCount(Menu menu);

    /**
     * 通过角色编号查询菜单
     *
     * @param pid
     * @param roleIds
     * @return
     */
    List<Menu> getMenuListByRoleId(@Param("pid") Integer pid, @Param("roleIds") String[] roleIds);

}
