package com.limbo.search.util.pattern;

import com.limbo.search.sh.vo.QueryConditionsVO;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public class ConditionContext {

    private ConditionStrategy strategy;

    public ConditionContext(ConditionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ConditionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 执行策略
     * @param conditionsVO
     * @return
     */
    public String executeStrategy(QueryConditionsVO conditionsVO){
        return strategy.doBuildSql(conditionsVO);
    }
}
