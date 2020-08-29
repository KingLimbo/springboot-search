package com.limbo.search.sh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Search0201ResultVO {

    /**
     * 数据库名称
     */
    private String schame;

    /**
     * 表格
     */
    private String table;

    /**
     * 表格名称
     */
    private String tableName;

    /**
     * 字段
     */
    private String cloumn;

    /**
     * 字段名称
     */
    private String cloumnName;

    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 查询数据结果
     */
    private Object data;
}
