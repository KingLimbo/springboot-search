package com.limbo.search.util;

import com.limbo.search.util.pattern.*;
import com.limbo.search.sh.vo.QueryConditionsVO;

import java.util.List;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/26
 */
public class DataUtils {

    private static final String AND = " AND ";

    /**
     * 构建SQL查询条件
     *
     * @param queryConditionsList
     * @return
     */
    public static String buildSqlWhere(List<QueryConditionsVO> queryConditionsList){
        StringBuffer sql = new StringBuffer();
        // 判断参数是否为空
        if (null == queryConditionsList || queryConditionsList.size() == 0) {
            return "";
        }
        ConditionContext context = new ConditionContext(new ConditionStrategy01Impl());
        for (QueryConditionsVO conditionsVO: queryConditionsList) {
            if ("01".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy01Impl());
            } else if ("02".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy02Impl());
            } else if ("03".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy03Impl());
            } else if ("04".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy04Impl());
            } else if ("05".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy05Impl());
            } else if ("06".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy06Impl());
            } else if ("07".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy07Impl());
            } else if ("08".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy08Impl());
            } else if ("09".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy09Impl());
            } else if ("10".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy10Impl());
            } else if ("11".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy11Impl());
            } else if ("12".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy12Impl());
            } else if ("13".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy13Impl());
            } else if ("14".equals(conditionsVO.getCalculation())) {
                context.setStrategy(new ConditionStrategy14Impl());
            }
            sql.append(AND);
            sql.append(context.executeStrategy(conditionsVO));
        }
        return sql.toString();
    }
}
