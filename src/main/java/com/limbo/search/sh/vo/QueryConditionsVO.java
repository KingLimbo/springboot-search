package com.limbo.search.sh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryConditionsVO {

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 查询条件
     */
    private String calculation;

    /**
     * 后置查询
     */
    private String after;
}
