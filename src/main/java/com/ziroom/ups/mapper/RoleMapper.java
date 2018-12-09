package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * RoleMapper继承基类
 */
@Mapper
public interface RoleMapper extends MyBatisBaseMapper<RoleEntity, Integer> {
}