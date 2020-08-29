package com.limbo.search.sys.service;

import java.util.Map;

/**
 *Service
 */
public interface CensusService {
    Map<String, Integer> getCensusMap();
    Map<String, Object> getCensusUserMap();
}
