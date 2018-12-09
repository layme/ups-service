package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper继承基类
 */
@Mapper
public interface UserMapper extends MyBatisBaseMapper<UserEntity, Integer> {
}