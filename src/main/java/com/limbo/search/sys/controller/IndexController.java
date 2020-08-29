package com.limbo.search.sys.controller;

import com.limbo.search.sys.service.CensusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * describe: 系统首页统计图
 * current user Maochao.zhu
 * current system 2019/11/23
 */
@Controller
@RequestMapping("/census")
public class IndexController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CensusService censusService;
    /**
     * 去首页
     * @return
     */
    @RequestMapping("goIndex")
    public ModelAndView goIndex(){
        ModelAndView modelView = new ModelAndView();
        //跳转到首页统计图、在这里查询赋值、然后在页面展示就可以了
        modelView.addObject("total",censusService.getCensusMap());
        modelView.addObject("userMap",censusService.getCensusUserMap());
        modelView.setViewName("views/census/index");
        return modelView;
    }
}
