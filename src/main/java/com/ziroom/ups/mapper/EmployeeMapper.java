package com.ziroom.ups.mapper;

import com.ziroom.ups.model.dto.EmpListDto;
import com.ziroom.ups.model.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * EmployeeDao继承基类
 */
@Mapper
@Component
public interface EmployeeMapper {

    int insert(EmployeeEntity employeeEntity);

    EmployeeEntity selectByFid(@Param("fid") String fid);

    int updateByFid(EmployeeEntity employeeEntity);

    List<EmployeeEntity> listPage(EmpListDto empListDto);
}