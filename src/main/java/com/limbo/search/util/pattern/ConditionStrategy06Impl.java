package com.limbo.search.util.pattern;

import com.limbo.search.sh.vo.QueryConditionsVO;
import org.springframework.util.StringUtils;

/**
 * search 小于等于关系
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public class ConditionStrategy06Impl implements ConditionStrategy {
    /**
     * 创建SQL
     *
     * @param conditionsVO
     * @return
     */
    @Override
    public String doBuildSql(QueryConditionsVO conditionsVO) {
        String sql = "1 = 1";
        // 判断是否为空
        if (!StringUtils.isEmpty(conditionsVO.getName()) && !StringUtils.isEmpty(conditionsVO.getValue())){
            sql = " `" + conditionsVO.getName() + "` <= '" + conditionsVO.getValue() + "'";
        }
        return sql;
    }
}
