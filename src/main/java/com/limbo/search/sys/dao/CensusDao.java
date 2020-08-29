package com.limbo.search.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CensusDao {
    Integer getRoleCount();

    Integer getUserCount();

    List<Map<String, Object>> getUserTypeCount();

    List<Map<String, Object>> getRoleUserCount();

    List<Map<String, Object>> getUserVisitRate();
}
