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
public class Search0201CdnVO extends BaseVo {

    /**
     * 数据库名称
     */
    private String schame;

    /**
     * 表格名称
     */
    private String table;

    /**
     * 查询条件
     */
    private String calculation;
}
