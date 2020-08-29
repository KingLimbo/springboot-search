package com.limbo.search.sh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableResultVO<T> {

    /**
     * 状态
     */
    private Integer code;
    /**
     * 数量
     */
    private Long count;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private List<T> data;
}
