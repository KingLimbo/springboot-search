package com.limbo.search.sh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.limbo.search.sh.dao.Search0201Mapper;
import com.limbo.search.sh.service.Search0201Service;
import com.limbo.search.util.DataUtils;
import com.limbo.search.sh.vo.Search0201CdnVO;
import com.limbo.search.sh.vo.Search0201ResultVO;
import com.limbo.search.sh.vo.TableResultVO;
import com.limbo.search.sh.vo.TableSearchVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/21
 */
@Service
@Slf4j
public class Search0201ServiceImpl implements Search0201Service {

    @Resource
    Search0201Mapper search0201Mapper;

    /**
     * 查询表
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    @Override
    public TableResultVO listTablesQuery(Search0201CdnVO search0201CdnVO) {
        TableResultVO<Search0201ResultVO> resultVO = new TableResultVO();
        try {
            resultVO.setCode(0);
            List<Search0201ResultVO> resultVOList =  search0201Mapper.selectTables(search0201CdnVO);
            resultVO.setData(resultVOList);
        } catch (Exception e) {
            log.info(e.getMessage());
            resultVO.setCode(1);
            resultVO.setMsg(e.getMessage());
        }
        return resultVO;
    }

    /**
     * 查询字段
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    @Override
    public TableResultVO listCloumnsQuery(Search0201CdnVO search0201CdnVO) {
        TableResultVO<Search0201ResultVO> resultVO = new TableResultVO();
        try {
            resultVO.setCode(0);
            List<Search0201ResultVO> resultVOList =  search0201Mapper.selectCloumns(search0201CdnVO);
            resultVO.setData(resultVOList);
        } catch (Exception e) {
            log.info(e.getMessage());
            resultVO.setCode(1);
            resultVO.setMsg(e.getMessage());
        }
        return resultVO;
    }

    /**
     * 查询数据通过表
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    @Override
    public TableResultVO listDataQueryByTable(Search0201CdnVO search0201CdnVO) {
        // 初始化返回结果
        TableResultVO resultVO = new TableResultVO();
        try {
            resultVO.setCode(0);
            if (StringUtils.isEmpty(search0201CdnVO.getSchame()) || StringUtils.isEmpty(search0201CdnVO.getTable())) {
                // 返回结果
                return resultVO;
            }
            // 重新查询列
            List<Search0201ResultVO> resultVOList =  search0201Mapper.selectCloumns(search0201CdnVO);
            List<String> cloumns = new ArrayList<>();
            // 循环创建列
            for (Search0201ResultVO item : resultVOList) {
                cloumns.add(item.getCloumn());
            }
            // 初始化查询条件
            TableSearchVO searchVO = new TableSearchVO();
            searchVO.setCloumns(cloumns);
            searchVO.setSchame(search0201CdnVO.getSchame());
            searchVO.setTable(search0201CdnVO.getTable());
            searchVO.setQueryConditions(DataUtils.buildSqlWhere(search0201CdnVO.getQueryConditionsList()));
            PageHelper.startPage(search0201CdnVO.getPage(), search0201CdnVO.getLimit());
            // 查询具体数据
            List<Map> mapList =  search0201Mapper.selectData(searchVO);
            PageInfo<Map> pageInfo = new PageInfo<Map>(mapList);
            // 设置结果集
            resultVO.setData(mapList);
            // 设置查询总数量
            resultVO.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            log.info(e.getMessage());
            resultVO.setCode(1);
            resultVO.setMsg(e.getMessage());
        }
        // 返回结果
        return resultVO;
    }
}
