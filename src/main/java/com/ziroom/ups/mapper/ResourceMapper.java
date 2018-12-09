package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * ResourceMapper继承基类
 */
@Mapper
public interface ResourceMapper extends MyBatisBaseMapper<ResourceEntity, Integer> {
}