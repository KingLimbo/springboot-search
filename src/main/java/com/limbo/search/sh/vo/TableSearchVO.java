package com.limbo.search.sh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/23
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableSearchVO extends BaseVo {

    /**
     * 数据字段列表
     */
    private List<String> cloumns;

    /**
     * 数据库名
     */
    private String schame;

    /**
     * 表名
     */
    private String table;
}
