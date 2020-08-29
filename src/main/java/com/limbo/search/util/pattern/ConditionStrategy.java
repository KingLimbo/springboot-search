package com.limbo.search.util.pattern;

import com.limbo.search.sh.vo.QueryConditionsVO;

/**
 * search 策略模式
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public interface ConditionStrategy {
    /**
     * 创建SQL
     *
     * @param conditionsVO
     * @return
     */
    String doBuildSql(QueryConditionsVO conditionsVO);
}
