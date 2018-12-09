package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserRoleMapper继承基类
 */
@Mapper
public interface UserRoleMapper extends MyBatisBaseMapper<UserRoleEntity, Integer> {
}