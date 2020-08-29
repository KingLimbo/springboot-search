package com.limbo.search.sh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseVo {
    /**
     * 查询条件字符串
     */
    protected String queryConditions;

    /**
     * 当前页码
     */
    protected Integer page;

    /**
     * 每页数据的数量
     */
    protected Integer limit;

    /**
     * 查询条件数组
     */
    protected List<QueryConditionsVO> queryConditionsList;
}
