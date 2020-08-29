package com.limbo.search.util.pattern;

import com.limbo.search.sh.vo.QueryConditionsVO;
import org.springframework.util.StringUtils;

/**
 * search 在列表中关系
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public class ConditionStrategy11Impl implements ConditionStrategy {
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
            String[] array = conditionsVO.getValue().split(",");
            String arrayStr = "";
            for (int i = 0; i < array.length; i++) {
                if ("".equals(arrayStr)) {
                    arrayStr = "('" + array[i] + "'";
                } else {
                    arrayStr += ",'" + array[i] + "'";
                }
            }
            if (!"".equals(arrayStr)) {
                arrayStr += ")";
                sql = " `" + conditionsVO.getName() + "` IN " + arrayStr;
            }
        }
        return sql;
    }
}
