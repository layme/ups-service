package com.ziroom.ups.mapper;

import com.ziroom.ups.model.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * EmployeeDao继承基类
 */
@Mapper
public interface EmployeeMapper extends MyBatisBaseMapper<EmployeeEntity, Integer> {
}