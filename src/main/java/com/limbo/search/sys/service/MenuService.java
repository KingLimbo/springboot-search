package com.limbo.search.sys.service;

import com.limbo.search.sys.po.Menu;

import java.util.List;

/**
 * 菜单Service
 *
 * @author Maochao-zhu
 */
public interface MenuService {
    public Integer insertMenu(Menu menu);

    public Integer deleteMenuById(String[] ids);

    public Integer updateMenuById(Menu menu);

    public Menu getMenuById(Integer id);

    public List<Menu> getMenuList(Menu menu);

    public List<Menu> getMenuListAll();

    public Integer getMenuListCount(Menu menu);

    /**
     * 根据角色编号查询左侧菜单
     *
     * @param roleIds
     * @return
     */
    List<Menu> getMenuLeft(String[] roleIds);

}
