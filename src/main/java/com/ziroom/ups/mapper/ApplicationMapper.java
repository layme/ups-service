package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.ApplicationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * ApplicationDao继承基类
 */
@Mapper
public interface ApplicationMapper extends MyBatisBaseMapper<ApplicationEntity, Integer> {
}