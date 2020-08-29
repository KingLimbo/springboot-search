package com.limbo.search.sys.service.impl;

import com.limbo.search.sys.dao.CensusDao;
import com.limbo.search.sys.service.CensusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author King.LF
 */
@Service
public class CensusServiceImpl implements CensusService {
    @Resource
    CensusDao sensusDao;

    @Override
    public Map<String, Integer> getCensusMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("roleCount", sensusDao.getRoleCount());
        map.put("userCount", sensusDao.getUserCount());
        return map;
    }

    @Override
    public Map<String, Object> getCensusUserMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("userTypeMap", sensusDao.getUserTypeCount());
        map.put("roleUserMap", sensusDao.getRoleUserCount());
        map.put("visitRateMap", sensusDao.getUserVisitRate());
        return map;
    }
}
