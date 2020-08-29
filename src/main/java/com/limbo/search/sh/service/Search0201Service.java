package com.limbo.search.sh.service;

import com.limbo.search.sh.vo.Search0201CdnVO;
import com.limbo.search.sh.vo.TableResultVO;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/21
 */
public interface Search0201Service {

    /**
     * 查询表
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    TableResultVO listTablesQuery(Search0201CdnVO search0201CdnVO);

    /**
     * 查询字段
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    TableResultVO listCloumnsQuery(Search0201CdnVO search0201CdnVO);

    /**
     * 查询数据通过表
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    TableResultVO listDataQueryByTable(Search0201CdnVO search0201CdnVO);
}
