package xyz.kingsword.gateway.dao;

import xyz.kingsword.gateway.bean.Classify;

public interface ClassifyMapper {
    int insert(Classify record);

    int insertSelective(Classify record);
}
