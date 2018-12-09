package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.RoleResourceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * RoleResourceMapper继承基类
 */
@Mapper
public interface RoleResourceMapper extends MyBatisBaseMapper<RoleResourceEntity, Integer> {
}