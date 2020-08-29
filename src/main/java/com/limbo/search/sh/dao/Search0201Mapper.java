package com.limbo.search.sh.dao;

import com.limbo.search.sh.vo.Search0201CdnVO;
import com.limbo.search.sh.vo.Search0201ResultVO;
import com.limbo.search.sh.vo.TableSearchVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * search
 *
 * @author : limbo
 * @date : 2020/7/21
 */
@Mapper
public interface Search0201Mapper {

    /**
     * 查询表
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    List<Search0201ResultVO> selectTables(Search0201CdnVO search0201CdnVO);

    /**
     * 查询字段
     *
     * @param search0201CdnVO 页面查询参数
     * @return
     */
    List<Search0201ResultVO> selectCloumns(Search0201CdnVO search0201CdnVO);

    /**
     * 查询数据
     *
     * @param searchVO 处理后查询参数
     * @return
     */
    List<Map> selectData(TableSearchVO searchVO);
}
