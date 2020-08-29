package com.limbo.search.util.pattern;

import com.limbo.search.sh.vo.QueryConditionsVO;
import org.springframework.util.StringUtils;

/**
 * search 包含关系
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public class ConditionStrategy13Impl implements ConditionStrategy {

    private static final String NULL ="NULL";
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
        if (!StringUtils.isEmpty(conditionsVO.getName())){
            sql = " `" + conditionsVO.getName();
            if (StringUtils.isEmpty(conditionsVO.getValue())){
                conditionsVO.setValue(NULL);
                sql += "` BETWEEN " + NULL;
            } else {
                sql += "` BETWEEN '" + conditionsVO.getValue() + "'" ;;
            }
            if (StringUtils.isEmpty(conditionsVO.getAfter())){
                sql += " AND " + NULL;
            } else {
                sql += " AND '"+ conditionsVO.getAfter() + "'";
            }
        }
        return sql;
    }
}
