package com.limbo.search.sh.controller;

import com.limbo.search.sh.service.Search0201Service;
import com.limbo.search.sh.vo.Search0201CdnVO;
import com.limbo.search.sh.vo.TableResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/20
 */
@Controller
@Slf4j
@RequestMapping("/search/sh0201")
public class Search0201Controller {

    @Resource
    Search0201Service search0201Service;

    @RequestMapping("/init")
    public ModelAndView init(){
        ModelAndView view = new ModelAndView("/search/sh0201");
        return view;
    }

    @RequestMapping("/queryTables")
    @ResponseBody
    public TableResultVO queryTables(Search0201CdnVO search0201CdnVO){
        TableResultVO resultVO = search0201Service.listTablesQuery(search0201CdnVO);
        return resultVO;
    }


    @RequestMapping("/queryCloumns")
    @ResponseBody
    public TableResultVO queryCloumns(Search0201CdnVO search0201CdnVO){
        TableResultVO resultVO = search0201Service.listCloumnsQuery(search0201CdnVO);
        return resultVO;
    }


    @RequestMapping("/queryData")
    @ResponseBody
    public TableResultVO queryData(Search0201CdnVO search0201CdnVO){
        TableResultVO resultVO = search0201Service.listDataQueryByTable(search0201CdnVO);
        return resultVO;
    }
}
